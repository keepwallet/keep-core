package keep.core.crypto.impl

import keep.core.crypto.EntropyGenerator
import keep.core.crypto.WalletAdapter
import keep.core.crypto.model.Seed
import keep.core.crypto.model.SignInput
import keep.core.crypto.model.SignOutput
import keep.core.model.Account
import keep.core.model.Address
import keep.core.model.Chain

class FakeWalletAdapter(
    private val entropyGenerator: EntropyGenerator = FakeEntropyGenerator()
) : WalletAdapter {
    override suspend fun generateSeed(chains: List<Chain>): Seed
        = Seed(entropyGenerator.generate(), "")

    override suspend fun generateAccount(seed: Seed, chain: Chain, index: Int): Account
        = Account(chain, 0, Address("0xabcdef123456789abc"))

    override suspend fun sign(seed: Seed, input: SignInput): SignOutput = object : SignOutput {
        override val data: ByteArray
            get() = byteArrayOf()
    }
}