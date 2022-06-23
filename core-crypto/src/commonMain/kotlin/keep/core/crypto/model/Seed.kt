package keep.core.crypto.model

data class Seed(
    val data: ByteArray,
    val password: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Seed

        if (!data.contentEquals(other.data)) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + password.hashCode()
        return result
    }
}