package keep.blockchain.smartchain

import com.ionspin.kotlin.bignum.integer.BigInteger

class WalletCoreAbi : Abi {
    override fun toContractFunction(ownerAddress: String): String = ownerAddress

    override fun decodeUInt256ABI(data: String): BigInteger = BigInteger.ZERO
}