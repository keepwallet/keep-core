package keep.core.data

import keep.core.model.Account
import keep.core.model.Asset

interface AssetsRepository {

    suspend fun getAssets(): Map<Account, List<Asset>>

    suspend fun getAssets(account: Account): List<Asset>

    suspend fun addAsset(account: Account, asset: Asset): Boolean

    suspend fun removeAsset(account: Account, asset: Asset): Boolean

    suspend fun getAssetById(account: Account, id: String): Asset?

    suspend fun searchAssetsByName(name: String): Map<Account?, List<Asset>>
}