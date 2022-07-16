package keep.core.feature.assets.model

data class AssetUIState(
    val assetId: String,
    val iconUrl: String,
    val title: String,
    val conversionPrice: String,
    val conversionChanges: String,
    val conversionChangesColor: Long,
    val amount: String,
    val conversionAmount: String,
)