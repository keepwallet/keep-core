package keep.core.data.balances

import keep.core.data.model.AssetSummary

interface LocalBalancesStore {
    fun getAll(): Map<String, Balances> // TODO: ????

    fun getAll(assets: List<AssetSummary>): List<AssetSummary> // TODO: ???

    fun getByAsset(assetSummary: AssetSummary): AssetSummary

    fun save(assets: List<AssetSummary>): Boolean

    fun getLastUpdate(): Long

    fun clean(): Boolean
}