package keep.core.feature.assets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import keep.core.feature.assets.model.AssetsHeadUIState

@Composable
fun AssetListHeadCard(
    assetsHead: AssetsHeadUIState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        //TODO: Auto size text + middle ellipsize
        Text(
            text = assetsHead.totalConversionAmount,
            style = MaterialTheme.typography.headlineMedium,
            maxLines = 1,
            softWrap = false,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Text(
            text = assetsHead.walletName,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview("Asset list head")
@Composable
fun PreviewAssetListHead() {
    MaterialTheme {
        AssetListHeadCard(
            assetsHead = AssetsHeadUIState(
                walletName = "Preview wallet",
                totalConversionAmount = "250 000,87 $"
            )
        )
    }
}