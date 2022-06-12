package keep.core.blockchain

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
}