package keep.core.data

import keep.core.model.Account
import keep.core.model.Asset

interface AssetsRepository {

    suspend fun getAssets(): List<AssetSummary>

    suspend fun getAssets(account: Account): List<AssetSummary>

    suspend fun addAsset(account: Account, asset: Asset): Boolean

    suspend fun removeAsset(account: Account, asset: Asset): Boolean

    suspend fun getAssetById(account: Account, id: String): AssetSummary?

    suspend fun searchAssetsByName(name: String): List<AssetSummary>
}