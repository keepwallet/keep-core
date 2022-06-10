package keep.core.blockchain

import keep.core.model.Chain

interface BlockchainInfoSource {
    fun getCoinType(chain: Chain): Int
    fun getNetworkId(chain: Chain): String
    fun getNetworkName(chain: Chain): String
    fun getNativeDecimals(chain: Chain): Int
    fun getNativeSymbol(chain: Chain): String
}

object BlockchainInfoSourceInst {
    lateinit var source: BlockchainInfoSource
}