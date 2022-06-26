package keep.core.data

import keep.core.crypto.model.Seed

interface SeedStore {
    fun getSeed(walletId: String): Seed?

    fun addSeed(walletId: String): Boolean

    fun removeSeed(walletId: String): Boolean
}