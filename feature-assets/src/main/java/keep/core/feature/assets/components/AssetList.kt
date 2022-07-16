package keep.core.feature.assets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import keep.core.feature.assets.model.AssetUIState
import keep.core.feature.assets.model.AssetsHeadUIState
import keep.core.feature.assets.model.AssetsUIState

@Composable
fun AssetList(
    state: AssetsUIState,
    modifier: Modifier = Modifier,
    onAssetClick: (assetId: String) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier,
    ) {
        item {
            AssetListHeadCard(state.head)
        }
        items(state.assets) {
            AssetListCard(asset = it, modifier.clickable { onAssetClick(it.assetId) })
        }
    }
}

@Preview
@Composable
fun PreviewAssetList() {
    val assetsState = AssetsUIState(
        head = AssetsHeadUIState(
            walletName = "Preview Wallet",
            totalConversionAmount = "210 000 $"
        ),
        assets = listOf(
            AssetUIState(
                assetId = "btc_id",
                iconUrl = "",
                title = "Bitcoin",
                conversionPrice = "21 000$",
                conversionChanges = "+1.5%",
                conversionChangesColor = 0xff00cf00,
                conversionAmount = "210 000$",
                amount = "10 BTC",
            ),
            AssetUIState(
                assetId = "bnb_id",
                iconUrl = "",
                title = "Binance",
                conversionPrice = "2100$",
                conversionChanges = "-1.5%",
                conversionChangesColor = 0xffcf0000,
                conversionAmount = "21 000$",
                amount = "10 BNB",
            )
        )
    )
    AssetList(state = assetsState)
}