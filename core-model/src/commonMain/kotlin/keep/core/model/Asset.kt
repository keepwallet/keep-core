package keep.core.model

data class Asset(
    val id: String, // URN by CAIP-10: eth:1:0x00abcdef
    val name: String,
    val symbol: String,
    val decimals: Int,
) {
    fun getAssetAddress(): Address? {
        val parts = id.split(':')
        return if (parts.size > 2) {
            Address(parts[2])
        } else {
            null
        }
    }

    fun getTokenStandard() = try {
        val parts = id.split(':')
        val name = parts.firstOrNull() ?: "native"
        TokenStandard.valueOf(name)
    } catch (err: Throwable) {
        TokenStandard.native
    }

    fun getChainId(): String? {
        val parts = id.split(':')
        return if (parts.size > 1) {
            parts[1]
        } else {
            null
        }
    }
}