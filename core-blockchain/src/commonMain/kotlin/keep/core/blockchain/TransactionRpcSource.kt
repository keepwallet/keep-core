package keep.core.blockchain

import keep.core.model.Account
import keep.core.model.Transaction

interface TransactionRpcSource {
    suspend fun sendTransaction(account: Account, signedMessage: ByteArray): String

    suspend fun findTransaction(account: Account, hash: String): Transaction
}