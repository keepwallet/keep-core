package keep.core.blockchain

import keep.core.model.Coin
import keep.core.model.Measure

interface BlockchainInfoSource {
    fun getCoinType(coin: Coin): Int
    fun getNetworkId(coin: Coin): String
    fun getNetworkName(coin: Coin): String
    fun getNativeMeasure(coin: Coin): Measure
}

object BlockchainInfoSourceInst {
    lateinit var source: BlockchainInfoSource
}