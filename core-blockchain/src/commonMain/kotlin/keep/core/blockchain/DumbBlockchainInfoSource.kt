package keep.core.blockchain

import keep.core.model.Chain

private data class CoinInfo(
    val chain: Chain,
    val coinType: Int,
    val decimals: Int,
    val symbol: String,
    val networkId: String = chain::class.simpleName?.lowercase() ?: "",
    val networkName: String = chain::class.simpleName?.lowercase() ?: "",
)

class DumbBlockchainInfoSource : BlockchainInfoSource {
    
    private val data = arrayOf(
        CoinInfo(
            chain = Chain.Binance,
            coinType = 714,
            symbol = "BNB",
            decimals = 8,
        ),
        CoinInfo(
            chain = Chain.Bitcoin,
            coinType = 0,
            symbol = "BTC",
            decimals = 8,
        ),
        CoinInfo(
            chain = Chain.Ethereum,
            coinType = 60,
            symbol = "ETH",
            decimals = 18,
        ),
        CoinInfo(
            chain = Chain.BinanceSmartChain,
            coinType = 20000714,
            symbol = "BNB",
            decimals = 18,
        ),
    )

    override fun getCoinType(chain: Chain): Int = data.find(chain).coinType

    override fun getNetworkId(chain: Chain): String = data.find(chain).networkId

    override fun getNetworkName(chain: Chain): String = data.find(chain).networkName

    override fun getNativeDecimals(chain: Chain): Int = data.find(chain).decimals

    override fun getNativeSymbol(chain: Chain): String = data.find(chain).symbol

    private fun Array<CoinInfo>.find(chain: Chain) = first { it.chain == chain }
}