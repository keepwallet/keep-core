package keep.core.blockchain

import keep.core.model.Coin
import keep.core.model.Measure

private data class CoinInfo(
    val coin: Coin,
    val coinType: Int,
    val nativeMeasure: Measure,
    val networkId: String = coin.name.lowercase(),
    val networkName: String = coin.name.lowercase(),
)

class DumbBlockchainInfoSource : BlockchainInfoSource {
    
    private val data = arrayOf(
        CoinInfo(
            coin = Coin.AETERNITY,
            coinType = 457,
            nativeMeasure = Measure("AE", 18),
        ),
        CoinInfo(
            coin = Coin.AION,
            coinType = 455,
            nativeMeasure = Measure("AION", 18),
        ),
        CoinInfo(
            coin = Coin.BINANCE,
            coinType = 714,
            nativeMeasure = Measure("BNB", 8),
        ),
        CoinInfo(
            coin = Coin.BITCOIN,
            coinType = 0,
            nativeMeasure = Measure("BTC", 8),
        ),
        CoinInfo(
            coin = Coin.BITCOINCASH,
            coinType = 145,
            nativeMeasure = Measure("BCH", 8),
        ),
        CoinInfo(
            coin = Coin.BITCOINGOLD,
            coinType = 156,
            nativeMeasure = Measure("BTG", 8),
        ),
        CoinInfo(
            coin = Coin.CALLISTO,
            coinType = 820,
            nativeMeasure = Measure("CLO", 18),
        ),
        CoinInfo(
            coin = Coin.CARDANO,
            coinType = 1815,
            nativeMeasure = Measure("ADA", 6),
        ),
        CoinInfo(
            coin = Coin.ATOM,
            coinType = 118,
            nativeMeasure = Measure("ATOM", 6),
        ),
        CoinInfo(
            coin = Coin.DASH,
            coinType = 5,
            nativeMeasure = Measure("DASH", 8),
        ),
        CoinInfo(
            coin = Coin.DECRED,
            coinType = 42,
            nativeMeasure = Measure("DCR", 8),
        ),
        CoinInfo(
            coin = Coin.DIGIBYTE,
            coinType = 20,
            nativeMeasure = Measure("DGB", 8),
        ),
        CoinInfo(
            coin = Coin.DOGECOIN,
            coinType = 3,
            nativeMeasure = Measure("DOGE", 8),
        ),
        CoinInfo(
            coin = Coin.EOS,
            coinType = 194,
            nativeMeasure = Measure("EOS", 4),
        ),
        CoinInfo(
            coin = Coin.ETHEREUM,
            coinType = 60,
            nativeMeasure = Measure("ETH", 18),
        ),
        CoinInfo(
            coin = Coin.ETHEREUMCLASSIC,
            coinType = 61,
            nativeMeasure = Measure("ETC", 18),
        ),
        CoinInfo(
            coin = Coin.FIO,
            coinType = 235,
            nativeMeasure = Measure("FIO", 9),
        ),
        CoinInfo(
            coin = Coin.GOCHAIN,
            coinType = 6060,
            nativeMeasure = Measure("GO", 18),
        ),
        CoinInfo(
            coin = Coin.GROESTLCOIN,
            coinType = 17,
            nativeMeasure = Measure("GRS", 8),
        ),
        CoinInfo(
            coin = Coin.ICON,
            coinType = 74,
            nativeMeasure = Measure("ICX", 18),
        ),
        CoinInfo(
            coin = Coin.IOTEX,
            coinType = 304,
            nativeMeasure = Measure("IOTX", 18),
        ),
        CoinInfo(
            coin = Coin.KAVA,
            coinType = 459,
            nativeMeasure = Measure("KAVA", 6),
        ),
        CoinInfo(
            coin = Coin.KIN,
            coinType = 2017,
            nativeMeasure = Measure("KIN", 5),
        ),
        CoinInfo(
            coin = Coin.LITECOIN,
            coinType = 2,
            nativeMeasure = Measure("LTC", 8),
        ),
        CoinInfo(
            coin = Coin.MONACOIN,
            coinType = 22,
            nativeMeasure = Measure("MONA", 8),
        ),
        CoinInfo(
            coin = Coin.NEBULAS,
            coinType = 2718,
            nativeMeasure = Measure("NAS", 18),
        ),
        CoinInfo(
            coin = Coin.NULS,
            coinType = 8964,
            nativeMeasure = Measure("NULS", 8),
        ),
        CoinInfo(
            coin = Coin.NANO,
            coinType = 165,
            nativeMeasure = Measure("XNO", 30),
        ),
        CoinInfo(
            coin = Coin.NEAR,
            coinType = 397,
            nativeMeasure = Measure("NEAR", 24),
        ),
        CoinInfo(
            coin = Coin.NIMIQ,
            coinType = 242,
            nativeMeasure = Measure("NIM", 5),
        ),
        CoinInfo(
            coin = Coin.ONTOLOGY,
            coinType = 1024,
            nativeMeasure = Measure("ONT", 0),
        ),
        CoinInfo(
            coin = Coin.POANETWORK,
            coinType = 178,
            nativeMeasure = Measure("POA", 18),
        ),
        CoinInfo(
            coin = Coin.QTUM,
            coinType = 2301,
            nativeMeasure = Measure("QTUM", 8),
        ),
        CoinInfo(
            coin = Coin.XRP,
            coinType = 144,
            nativeMeasure = Measure("XRP", 6),
        ),
        CoinInfo(
            coin = Coin.SOLANA,
            coinType = 501,
            nativeMeasure = Measure("SOL", 9),
        ),
        CoinInfo(
            coin = Coin.STELLAR,
            coinType = 148,
            nativeMeasure = Measure("XLM", 7),
        ),
        CoinInfo(
            coin = Coin.TEZOS,
            coinType = 1729,
            nativeMeasure = Measure("", 8),
        ),
        CoinInfo(
            coin = Coin.THETA,
            coinType = 500,
            nativeMeasure = Measure("XTZ", 6),
        ),
        CoinInfo(
            coin = Coin.THUNDERTOKEN,
            coinType = 1001,
            nativeMeasure = Measure("TT", 18),
        ),
        CoinInfo(
            coin = Coin.NEO,
            coinType = 888,
            nativeMeasure = Measure("NEO", 8),
        ),
        CoinInfo(
            coin = Coin.TOMOCHAIN,
            coinType = 889,
            nativeMeasure = Measure("TOMO", 18),
        ),
        CoinInfo(
            coin = Coin.TRON,
            coinType = 195,
            nativeMeasure = Measure("TRX", 6),
        ),
        CoinInfo(
            coin = Coin.VECHAIN,
            coinType = 818,
            nativeMeasure = Measure("VET", 18),
        ),
        CoinInfo(
            coin = Coin.VIACOIN,
            coinType = 14,
            nativeMeasure = Measure("VIA", 8),
        ),
        CoinInfo(
            coin = Coin.WANCHAIN,
            coinType = 5718350,
            nativeMeasure = Measure("WAN", 18),
        ),
        CoinInfo(
            coin = Coin.ZCASH,
            coinType = 133,
            nativeMeasure = Measure("ZEC", 8),
        ),
        CoinInfo(
            coin = Coin.FIRO,
            coinType = 136,
            nativeMeasure = Measure("FIRO", 8),
        ),
        CoinInfo(
            coin = Coin.ZILLIQA,
            coinType = 313,
            nativeMeasure = Measure("ZIL", 12),
        ),
        CoinInfo(
            coin = Coin.ZELCASH,
            coinType = 19167,
            nativeMeasure = Measure("FLUX", 8),
        ),
        CoinInfo(
            coin = Coin.RAVENCOIN,
            coinType = 175,
            nativeMeasure = Measure("RVN", 8),
        ),
        CoinInfo(
            coin = Coin.WAVES,
            coinType = 5741564,
            nativeMeasure = Measure("WAVES", 8),
        ),
        CoinInfo(
            coin = Coin.TERRA,
            coinType = 330,
            nativeMeasure = Measure("LUNC", 6),
        ),
        CoinInfo(
            coin = Coin.HARMONY,
            coinType = 1023,
            nativeMeasure = Measure("ONE", 18),
        ),
        CoinInfo(
            coin = Coin.ALGORAND,
            coinType = 283,
            nativeMeasure = Measure("ALGO", 6),
        ),
        CoinInfo(
            coin = Coin.KUSAMA,
            coinType = 434,
            nativeMeasure = Measure("KSM", 12),
        ),
        CoinInfo(
            coin = Coin.POLKADOT,
            coinType = 354,
            nativeMeasure = Measure("DOT", 10),
        ),
        CoinInfo(
            coin = Coin.FILECOIN,
            coinType = 461,
            nativeMeasure = Measure("FIL", 18),
        ),
        CoinInfo(
            coin = Coin.ELROND,
            coinType = 508,
            nativeMeasure = Measure("eGLD", 18),
        ),
        CoinInfo(
            coin = Coin.BANDCHAIN,
            coinType = 494,
            nativeMeasure = Measure("BAND", 6),
        ),
        CoinInfo(
            coin = Coin.SMARTCHAIN,
            coinType = 20000714,
            nativeMeasure = Measure("BNB", 18),
        ),
        CoinInfo(
            coin = Coin.OASIS,
            coinType = 474,
            nativeMeasure = Measure("ROSE", 9),
        ),
        CoinInfo(
            coin = Coin.POLYGON,
            coinType = 966,
            nativeMeasure = Measure("MATIC", 18),
        ),
        CoinInfo(
            coin = Coin.THORCHAIN,
            coinType = 931,
            nativeMeasure = Measure("RUNE", 8),
        ),
        CoinInfo(
            coin = Coin.BLUZELLE,
            coinType = 483,
            nativeMeasure = Measure("BLZ", 6),
        ),
        CoinInfo(
            coin = Coin.OPTIMISM,
            coinType = 10000070,
            nativeMeasure = Measure("ETH", 18),
        ),
        CoinInfo(
            coin = Coin.ARBITRUM,
            coinType = 10042221,
            nativeMeasure = Measure("ETH", 18),
        ),
        CoinInfo(
            coin = Coin.XDAI,
            coinType = 10000100,
            nativeMeasure = Measure("xDAI", 18),
        ),
        CoinInfo(
            coin = Coin.FANTOM,
            coinType = 10000250,
            nativeMeasure = Measure("FTM", 18),
        ),
        CoinInfo(
            coin = Coin.CRYPTOORG,
            coinType = 394,
            nativeMeasure = Measure("CRO", 8),
        ),
        CoinInfo(
            coin = Coin.CELO,
            coinType = 52752,
            nativeMeasure = Measure("CELO", 18),
        ),
        CoinInfo(
            coin = Coin.RONIN,
            coinType = 10002020,
            nativeMeasure = Measure("RON", 18),
        ),
        CoinInfo(
            coin = Coin.OSMOSIS,
            coinType = 10000118,
            nativeMeasure = Measure("OSMO", 6),
        ),
        CoinInfo(
            coin = Coin.ECASH,
            coinType = 899,
            nativeMeasure = Measure("XEC", 2),
        ),
    )

    override fun getCoinType(coin: Coin): Int = data.find(coin).coinType

    override fun getNetworkId(coin: Coin): String = data.find(coin).networkId

    override fun getNetworkName(coin: Coin): String = data.find(coin).networkName

    override fun getNativeMeasure(coin: Coin): Measure = data.find(coin).nativeMeasure

    private fun Array<CoinInfo>.find(coin: Coin) = first { it.coin == coin }
}