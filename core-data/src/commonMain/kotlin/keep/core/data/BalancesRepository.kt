package keep.core.data

import keep.core.model.Balance

typealias Balances = List<Balance>

interface BalancesRepository {
    suspend fun getBalances(asset: AssetSummary): AssetSummary

    suspend fun setBalance(asset: AssetSummary, balances: Balances): Boolean
}