package keep.core.blockchain

import keep.core.model.Address
import keep.core.model.Asset
import keep.core.model.Chain
import keep.core.model.TokenStandard

sealed class NetworkInfo(
    val chain: Chain,
    val defaultChainId: String = "0",
    val meta: TxMetaType = TxMetaType.NONE,
    val feeType: FeeType = FeeType.PASSIVE,
    val validateAddress: (String) -> Boolean = { it.isNotEmpty() },
    val toAddress: (String) -> Address = { Address(it) },
) {
    val coinType: Int by lazy {
        BlockchainInfoSourceInst.source.getCoinType(chain)
    }

    val networkId: String by lazy {
        BlockchainInfoSourceInst.source.getNetworkId(chain)
    }

    val networkName: String by lazy {
        BlockchainInfoSourceInst.source.getNetworkName(chain)
    }

    val nativeDecimals: Int by lazy {
        BlockchainInfoSourceInst.source.getNativeDecimals(chain)
    }

    val nativeSymbol: String by lazy {
        BlockchainInfoSourceInst.source.getNativeSymbol(chain)
    }

    fun buildAssetId(
        standard: TokenStandard,
        chainId: String,
        address: String,
    ): String {
        return "${standard.name}:$chainId:$address"
    }

    fun buildAsset(
        standard: TokenStandard,
        assetAddress: Address,
        name: String = "NoName",
        chainId: String? = null,
        decimals: Int? = null,
        symbol: String? = null,
    ): Asset = Asset(
        id = buildAssetId(
            standard = standard,
            chainId = chainId ?: defaultChainId,
            address = assetAddress.toString(),
        ),
        name = if (standard == TokenStandard.native) {
            networkName
        } else {
            name
        },
        decimals = if (standard == TokenStandard.native) {
            nativeDecimals
        } else {
            decimals ?: throw IllegalArgumentException("Measure is not set")
        },
        symbol = if (standard == TokenStandard.native) {
            nativeSymbol
        } else {
            symbol ?: throw IllegalArgumentException("Measure is not set")
        },
    )
}

object Binance : NetworkInfo(
    chain = Chain.Binance,
    meta = TxMetaType.MEMO,
    defaultChainId = "Binance-Chain-Tigris",
)

private val chains: Array<NetworkInfo> = arrayOf(
    Binance,
)

fun findNetworkBy(coinType: Int): NetworkInfo {
    return chains.firstOrNull{ it.coinType == coinType}
        ?: throw IllegalArgumentException("Coin type: ${coinType} is not supported")
}

fun findNetworkBy(networkId: String): NetworkInfo {
    return chains.firstOrNull{ it.networkId == networkId}
        ?: throw IllegalArgumentException("Network Id: ${networkId} is not supported")
}