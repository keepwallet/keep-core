package keep.core.crypto.impl

import keep.core.crypto.EntropyGenerator
import keep.core.crypto.WalletAdapter
import keep.core.crypto.model.Seed
import keep.core.crypto.model.SignInput
import keep.core.crypto.model.SignOutput
import keep.core.model.Account
import keep.core.model.Chain

class FakeWalletAdapter(
    private val entropyGenerator: EntropyGenerator = FakeEntropyGenerator()
) : WalletAdapter {
    override suspend fun generateSeed(chains: List<Chain>): Seed {
        TODO("Not yet implemented")
    }

    override suspend fun generateAccount(seed: Seed, chain: Chain, index: Int): Account {
        TODO("Not yet implemented")
    }

    override suspend fun sign(seed: Seed, input: SignInput): SignOutput {
        TODO("Not yet implemented")
    }
}