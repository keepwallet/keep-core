package keep.core.feature.assets.model

data class AssetsUIState(
    val head: AssetsHeadUIState,
    val assets: List<AssetUIState>,
)