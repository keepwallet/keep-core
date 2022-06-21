package keep.core.crypto

class StubEntropyGenerator : EntropyGenerator {
    override fun generate(): ByteArray {
        val array = ByteArray(16)
        array.fill(1)
        return array
    }
}