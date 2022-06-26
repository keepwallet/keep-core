package keep.core.data.balances

import keep.core.data.model.AssetSummary
import keep.core.data.model.Session
import keep.core.model.Asset
import keep.core.model.Balance

typealias Balances = List<Balance>

interface BalancesRepository {
    suspend fun getBalances(session: Session, asset: Asset? = null): AssetSummary

    suspend fun update(session: Session, asset: Asset? = null): Boolean

    fun addOnBalancesListener(listener: OnBalancesListener)
}

interface OnBalancesListener {
    fun onBalancesChange()
}