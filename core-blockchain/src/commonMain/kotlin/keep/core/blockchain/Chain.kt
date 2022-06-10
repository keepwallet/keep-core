package keep.core.blockchain

import keep.core.model.*

sealed class Chain(
    val chain: keep.core.model.Chain,
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

    val nativeMeasure: Measure by lazy {
        BlockchainInfoSourceInst.source.getNativeMeasure(chain)
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
        measure: Measure? = null,
        account: Account? = null,
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
        measure = if (standard == TokenStandard.native) {
            nativeMeasure
        } else {
            measure ?: throw IllegalArgumentException("Measure is not set")
        },
        account = account,
    )
}

object Binance : Chain(
    chain = keep.core.model.Chain.Binance,
    meta = TxMetaType.MEMO,
    defaultChainId = "Binance-Chain-Tigris",
)

private val chains: Array<Chain> = arrayOf(
    Binance,
)

fun findNetworkBy(coinType: Int): Chain {
    return chains.firstOrNull{ it.coinType == coinType}
        ?: throw IllegalArgumentException("Coin type: ${coinType} is not supported")
}

fun findNetworkBy(networkId: String): Chain {
    return chains.firstOrNull{ it.networkId == networkId}
        ?: throw IllegalArgumentException("Network Id: ${networkId} is not supported")
}