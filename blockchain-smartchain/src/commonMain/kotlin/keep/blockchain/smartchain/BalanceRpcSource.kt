package keep.blockchain.smartchain

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import keep.blockchain.smartchain.model.GethMethodRequest
import keep.core.blockchain.BalanceRpcSource
import keep.core.blockchain.RpcError
import keep.core.model.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class BalanceRpcSource(
    private val client: HttpClient,
    private val requestIdProvider: RequestIdProvider = IncreaseRequestIdProvider(),
) : BalanceRpcSource {

    interface RequestIdProvider {
        fun getNextId(): Int
    }

    class IncreaseRequestIdProvider : RequestIdProvider {
        private var _id: Int = 0
        val id: Int
            get() {
                _id += 1
                return _id
            }
        override fun getNextId(): Int {
            return id
        }
    }

    override fun getChain(): Chain = Chain.BinanceSmartChain

    override suspend fun getBalances(accountAddress: String, assets: List<Asset>): List<List<Balance>> {
        val nativeBalance = assets.filter { it.getTokenStandard() == TokenStandard.native }
            .map { getNativeBalance(accountAddress) }
        getERC20Balance(accountAddress, assets.filter { it.getTokenStandard() == TokenStandard.erc20 })
        return emptyList()
    }

    private suspend fun getNativeBalance(address: String): List<Balance> {
        val params = listOf(address, BlockParameter.latest.name)
        val request = GethMethodRequest(
            id = requestIdProvider.getNextId(),
            jsonrpc = "2.0",
            method = RpcMethod.eth_getBalance.name,
            params
        )
        val requestBody = Json.encodeToString(request)
        val requestBuilder = HttpRequestBuilder()
        requestBuilder.header("Cache-Control", "no-cache")
        requestBuilder.method = HttpMethod.Post
        requestBuilder.setBody(requestBody)

        val response = client.get(builder = requestBuilder)
        if (!(response.status.value in 200..299)) {
            throw RpcError("Invalid response received: ${response.bodyAsText()}")
        }
        val responseBody = response.bodyAsText()
        val responseElement = Json.parseToJsonElement(responseBody).jsonObject
        val result = if (responseElement.containsKey("error")) {
            throw RpcError(responseElement.get("error").jsonObject.get("message").jsonPrimitive.content)
        } else {
            val result = responseElement.get("result").jsonObject
            if (result.isEmpty()) {
                throw RpcError("Invalid response: empty result")
            } else {
                result.jsonPrimitive.content
            }
        }
        return listOf(
            Available(BigInteger.parseString(result))
        )
    }

    private fun getERC20Balance(accountAddress: String, assets: List<Asset>) {

    }
}