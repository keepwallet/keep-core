package keep.core.blockchain

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.integer.BigInteger
import keep.core.model.FeeType
import keep.core.model.TxMetaType

interface ChainInfoSource {
    fun getChainId(): String
    fun getCoinType(): Int
    fun getNetworkId(): String
    fun getNetworkName(): String
    fun getNativeDecimals(): Int
    fun getNativeSymbol(): String
    fun getMetaType(): TxMetaType
    fun getFeeType(): FeeType

    fun convertFromGrain(value: String): BigDecimal
    fun convertFromGrain(value: BigInteger): BigDecimal
    fun convertToGrain(value: String): BigInteger
    fun convertToGrain(value: BigInteger): BigInteger
}