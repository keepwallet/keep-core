package keep.core.data

import keep.core.data.model.Session

interface SessionRepository {
    suspend fun setWallet(wallet: Wallet): Boolean

    fun currentSession(): Session

    fun addOnSessionListener(onSessionChange: OnSessionChange)
}

interface OnSessionChange {
    fun onSessionChange(session: Session)
}