package keep.core.data.assets

import keep.core.data.model.AssetSummary
import keep.core.data.model.Session
import keep.core.model.Account
import keep.core.model.Asset

interface AssetsRepository {

    suspend fun getAssets(): List<AssetSummary>

    suspend fun getAssets(account: Account): List<AssetSummary>

    suspend fun getAssets(assetId: String): List<AssetSummary>

    suspend fun getAssetById(account: Account, assetId: String): AssetSummary?

    suspend fun searchAssetsByName(name: String): List<AssetSummary>

    suspend fun update(account: Account? = null): Boolean

    suspend fun addAsset(account: Account, asset: Asset): Boolean

    suspend fun removeAsset(account: Account, assetId: String): Boolean
}