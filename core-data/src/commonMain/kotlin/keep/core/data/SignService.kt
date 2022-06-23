package keep.core.data

import keep.core.crypto.WalletAdapter
import keep.core.crypto.model.SignInput
import keep.core.data.model.Session

class SignService( // TODO: Is it Interact or Use case?
    private val seedStore: SeedStore,
    private val walletAdapter: WalletAdapter,
) {
    suspend fun sign(session: Session, input: SignInput) {
        val seed = seedStore.getSeed(session.wallet.id) ?: throw IllegalStateException("Seed not available")
        walletAdapter.sign(seed, input)
    }
}