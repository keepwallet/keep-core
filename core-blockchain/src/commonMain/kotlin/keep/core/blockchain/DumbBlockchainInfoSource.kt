package keep.core.blockchain

import keep.core.model.Chain
import keep.core.model.Measure

private data class CoinInfo(
    val chain: Chain,
    val coinType: Int,
    val nativeMeasure: Measure,
    val networkId: String = chain::class.simpleName?.lowercase() ?: "",
    val networkName: String = chain::class.simpleName?.lowercase() ?: "",
)

class DumbBlockchainInfoSource : BlockchainInfoSource {
    
    private val data = arrayOf(
        CoinInfo(
            chain = Chain.Binance,
            coinType = 714,
            nativeMeasure = Measure("BNB", 8),
        ),
        CoinInfo(
            chain = Chain.Bitcoin,
            coinType = 0,
            nativeMeasure = Measure("BTC", 8),
        ),
        CoinInfo(
            chain = Chain.Ethereum,
            coinType = 60,
            nativeMeasure = Measure("ETH", 18),
        ),
        CoinInfo(
            chain = Chain.BinanceSmartChain,
            coinType = 60,
            nativeMeasure = Measure("ETH", 18),
        ),
        CoinInfo(
            chain = Chain.BinanceSmartChain,
            coinType = 20000714,
            nativeMeasure = Measure("BNB", 18),
        ),
    )

    override fun getCoinType(chain: Chain): Int = data.find(chain).coinType

    override fun getNetworkId(chain: Chain): String = data.find(chain).networkId

    override fun getNetworkName(chain: Chain): String = data.find(chain).networkName

    override fun getNativeMeasure(chain: Chain): Measure = data.find(chain).nativeMeasure

    private fun Array<CoinInfo>.find(chain: Chain) = first { it.chain == chain }
}