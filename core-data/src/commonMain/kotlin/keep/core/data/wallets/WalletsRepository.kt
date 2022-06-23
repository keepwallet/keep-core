package keep.core.data.wallets

import keep.core.crypto.model.Wallet
import keep.core.model.Account

interface WalletsRepository {
    fun getWallets(): List<Wallet>

    fun getWallet(walletId: String): Wallet?

    fun getWallet(account: Account): Wallet?

    fun updateWalletInfo(wallet: Wallet): Boolean

    fun addWallet(wallet: Wallet): Boolean

    fun removeWallet(id: String): Boolean
}