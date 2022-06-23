package keep.core.crypto

import keep.core.crypto.model.Seed
import keep.core.crypto.model.SignInput
import keep.core.crypto.model.SignOutput
import keep.core.model.Account
import keep.core.model.Chain

interface WalletAdapter {

    suspend fun generateSeed(chains: List<Chain>): Seed

    suspend fun generateAccount(seed: Seed, chain: Chain, index: Int): Account

    suspend fun sign(seed: Seed, input: SignInput): SignOutput
}