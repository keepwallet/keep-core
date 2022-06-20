package keep.core.blockchain

import keep.core.model.Asset
import keep.core.model.Balance
import keep.core.model.Chain

interface BalanceRpcSource {
    fun getChain(): Chain
    suspend fun getBalances(accountAddress: String, assets: List<Asset>): List<List<Balance>>
}