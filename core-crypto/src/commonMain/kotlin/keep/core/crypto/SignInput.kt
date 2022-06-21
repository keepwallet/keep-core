package keep.core.crypto

import keep.core.model.Account
import keep.core.model.Address
import keep.core.model.Asset
import keep.core.model.Chain

sealed interface SignInput{
    val chain: Chain
}

data class MessageSignInput(
    override val chain: Chain,
    val data: ByteArray,
) : SignInput

data class TransferSignInput(
    override val chain: Chain,
    val from: Account,
    val to: Address,
    val amount: BigInteger,
    val asset: Asset,
    val payload: String,
) : SignInput