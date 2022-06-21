package keep.core.crypto

import keep.core.model.Account
import keep.core.model.Chain

interface WalletAdapter {
    suspend fun generate(chains: List<Chain>): ByteArray

    suspend fun generateAccounts(wallet: ByteArray, password: String, chains: Array<Chain>): List<Account>

    suspend fun sign(data: ByteArray, password: String, input: SignInput): SignOutput
}