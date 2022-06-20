package keep.core.data

import keep.core.model.Account
import keep.core.model.Asset
import keep.core.model.Balance

typealias Balances = List<Balance>

interface BalancesRepository {
    suspend fun getBalances(asset: Map<Account, List<Asset>>): Map<Asset, Balances>

    suspend fun setBalance(account: Account, asset: Asset, balances: Balances): Boolean
}