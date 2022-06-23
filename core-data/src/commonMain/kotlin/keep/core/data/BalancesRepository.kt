package keep.core.data

import keep.core.data.model.AssetSummary
import keep.core.data.model.Session
import keep.core.model.Balance

typealias Balances = List<Balance>

interface BalancesRepository {
    suspend fun getBalances(session: Session, asset: AssetSummary): AssetSummary

    suspend fun setBalance(session: Session, asset: AssetSummary, balances: Balances): Boolean

    fun addOnBalancesListener(listener: OnBalancesListener)
}

interface OnBalancesListener {
    fun onBalancesChange()
}