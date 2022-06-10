package keep.core.blockchain

internal interface EntropyGenerator {
    fun generate(): ByteArray?
}