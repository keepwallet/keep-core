package keep.core.crypto.impl

import keep.core.crypto.EntropyGenerator

class FakeEntropyGenerator : EntropyGenerator {
    override fun generate(): ByteArray {
        val array = ByteArray(16)
        array.fill(1)
        return array
    }
}