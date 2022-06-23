package keep.core.crypto

interface EntropyGenerator {
    fun generate(): ByteArray
}
