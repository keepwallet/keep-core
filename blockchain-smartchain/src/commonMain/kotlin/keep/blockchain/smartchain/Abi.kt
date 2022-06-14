package keep.blockchain.smartchain

import com.ionspin.kotlin.bignum.integer.BigInteger

interface Abi {
    fun toContractFunction(ownerAddress: String): String

    fun decodeUInt256ABI(data: String): BigInteger
}