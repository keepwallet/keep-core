package keep.core.blockchain

import keep.core.model.Chain
import keep.core.model.Measure

interface BlockchainInfoSource {
    fun getCoinType(chain: Chain): Int
    fun getNetworkId(chain: Chain): String
    fun getNetworkName(chain: Chain): String
    fun getNativeMeasure(chain: Chain): Measure
}

object BlockchainInfoSourceInst {
    lateinit var source: BlockchainInfoSource
}