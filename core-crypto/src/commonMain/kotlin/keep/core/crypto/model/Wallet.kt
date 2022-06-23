package keep.core.crypto.model

import keep.core.model.Account
import keep.core.model.Chain

data class Wallet(
    val id: String,
    val title: String,
    val accounts: List<Account>,
) {
    fun getAccount(chain: Chain): List<Account> = accounts.filter { it.chain == chain }

    fun defaultAccount() = accounts.firstOrNull()

    fun uniqueId() = defaultAccount()?.address?.value ?: throw IllegalStateException("Wallet is empty")
}