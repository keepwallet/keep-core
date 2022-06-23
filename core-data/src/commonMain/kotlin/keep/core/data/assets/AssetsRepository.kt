package keep.core.data.assets

import keep.core.data.model.AssetSummary
import keep.core.data.model.Session
import keep.core.model.Account
import keep.core.model.Asset

interface AssetsRepository {

    suspend fun getAssets(session: Session): List<AssetSummary>

    suspend fun getAssets(session: Session, account: Account): List<AssetSummary>

    suspend fun getAssets(session: Session, assetId: String): List<AssetSummary>

    suspend fun getAssetById(session: Session, account: Account, assetId: String): AssetSummary?

    suspend fun searchAssetsByName(session: Session, name: String): List<AssetSummary>

    suspend fun update(session: Session, account: Account? = null): Boolean

    suspend fun addAsset(session: Session, account: Account, asset: Asset): Boolean

    suspend fun removeAsset(session: Session, account: Account, assetId: String): Boolean
}