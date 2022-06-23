package keep.core.data.assets

import keep.core.data.model.AssetSummary
import keep.core.model.Account

interface LocalAssetsStore {
    fun fetchAll(): List<AssetSummary>

    fun findByAccount(account: Account): List<AssetSummary>

    fun findByAssetId(assetId: String): List<AssetSummary>

    fun findByName(name: String): List<AssetSummary>

    fun remove(account: Account, assetId: String): Boolean

    fun save(assets: List<AssetSummary>): Boolean

    fun clean(): Boolean
}