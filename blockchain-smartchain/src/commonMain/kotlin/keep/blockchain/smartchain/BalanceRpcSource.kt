package keep.blockchain.smartchain

import com.ionspin.kotlin.bignum.integer.BigInteger
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import keep.blockchain.smartchain.model.MethodRequest
import keep.core.blockchain.BalanceRpcSource
import keep.core.blockchain.RpcError
import keep.core.model.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*

class BalanceRpcSource(
    private val client: HttpClient,
    private val abi: Abi,
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

    override fun getChain(): Chain = Chain.BNBSmartChain

    override suspend fun getBalances(accountAddress: String, assets: List<Asset>): List<List<Balance>> {
        return assets.filter { it.getTokenStandard() == TokenStandard.native }
            .map { getNativeBalance(accountAddress) } +
            getERC20Balance(accountAddress, assets.filter { it.getTokenStandard() == TokenStandard.erc20 })
    }

    private suspend fun getNativeBalance(address: String): List<Balance> {
        val params = listOf(address, BlockParameter.latest.name)
        val request = MethodRequest(
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
            throw RpcError(responseElement.get("error")?.jsonObject?.get("message")?.jsonPrimitive?.content)
        } else {
            val result = responseElement.get("result")?.jsonObject
            if (result.isNullOrEmpty()) {
                throw RpcError("Invalid response: empty result")
            } else {
                result.jsonPrimitive.content
            }
        }
        return listOf(
            Available(BigInteger.parseString(result))
        )
    }

    private suspend fun getERC20Balance(accountAddress: String, assets: List<Asset>): List<List<Balance>> {
        if (assets.isEmpty()) {
            return emptyList()
        }
        val butchItems = assets.mapNotNull { it.getAssetAddress() }.map {
            val dataJson = JsonObject(
                mapOf(
                    "from" to JsonPrimitive(accountAddress),
                    "to" to JsonPrimitive(it.value),
                    "data" to JsonPrimitive(abi.toContractFunction(accountAddress)),
                )
            )
            JsonObject(
                mapOf(
                    "id" to JsonPrimitive(requestIdProvider.getNextId()),
                    "jsonrpc" to JsonPrimitive("2.0"),
                    "method" to JsonPrimitive(RpcMethod.eth_call.name),
                    "params" to JsonArray(
                        listOf(
                            dataJson,
                            JsonPrimitive(BlockParameter.latest.name)
                        )
                    )
                )
            )
        }
        val requestBuilder = HttpRequestBuilder()
        requestBuilder.header("Cache-Control", "no-cache")
        requestBuilder.method = HttpMethod.Post
        requestBuilder.setBody(JsonArray(butchItems).toString())

        val response = client.get(builder = requestBuilder)
        if (!(response.status.value in 200..299)) {
            throw RpcError("Invalid response received: ${response.bodyAsText()}")
        }

        val responseBody = response.bodyAsText()
        val jsonResponse = Json.parseToJsonElement(responseBody).jsonArray
        return jsonResponse.map {
            val value = abi.decodeUInt256ABI(it.jsonObject["result"]?.jsonPrimitive?.content ?: "0") ?: BigInteger.ZERO
            listOf(Available(value = value))
        }
    }
}