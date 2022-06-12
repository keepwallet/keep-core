package keep.blockchain.smartchain

import keep.core.blockchain.ChainInfoSource
import keep.core.model.FeeType
import keep.core.model.TxMetaType

class ChainInfoSource : ChainInfoSource {
    override fun getChainId(): String = ""

    override fun getCoinType(): Int {
        TODO("Not yet implemented")
    }

    override fun getNetworkId(): String = "bsm"

    override fun getNetworkName(): String = "binancesmartchain"

    override fun getNativeDecimals(): Int = 18

    override fun getNativeSymbol(): String = "BNB"

    override fun getMetaType(): TxMetaType = TxMetaType.PAYLOAD

    override fun getFeeType(): FeeType = FeeType.ACTIVE
}