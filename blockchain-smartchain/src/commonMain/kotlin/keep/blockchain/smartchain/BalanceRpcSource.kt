package keep.blockchain.smartchain

import io.ktor.client.*
import keep.core.blockchain.BalanceRpcSource
import keep.core.model.Asset
import keep.core.model.Balance
import keep.core.model.Chain

class BalanceRpcSource(client: HttpClient) : BalanceRpcSource {

    override fun getChain(): Chain = Chain.BinanceSmartChain

    override suspend fun getBalances(assets: List<Asset>): List<List<Balance>> {
        return emptyList()
    }
}