package keep.core.data.session

import keep.core.crypto.model.Wallet
import keep.core.data.model.Session

interface SessionRepository {
    suspend fun change(wallet: Wallet): Boolean

    fun current(): Session

    fun addOnSessionListener(onSessionChange: OnSessionChange)
}

interface OnSessionChange {
    fun onSessionChange(session: Session)
}