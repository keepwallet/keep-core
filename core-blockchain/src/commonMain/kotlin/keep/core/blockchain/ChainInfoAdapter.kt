package keep.core.blockchain

import keep.core.model.Chain

object ChainInfoAdapter {
    private val sources: MutableMap<Chain, ChainInfoSource> = mutableMapOf()

    fun put(chain: Chain, source: ChainInfoSource) {
        sources[chain] = source
    }

    fun get(chain: Chain): ChainInfoSource = sources[chain] ?: throw IllegalStateException("Chain not found")
}