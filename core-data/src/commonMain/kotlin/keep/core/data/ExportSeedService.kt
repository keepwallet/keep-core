package keep.core.data

import keep.core.crypto.model.Seed

abstract class ExportSeedService(
    private val seedStore: SeedStore,
) {
    suspend fun export(walletId: String): String {
        val seed = seedStore.getSeed(walletId) ?: throw IllegalStateException("Seed not available")
        return toHumanReadable(seed)
    }

    abstract fun toHumanReadable(seed: Seed): String
}

//TODO: !!! - expect fun toHumanReadable(seed: Seed): String