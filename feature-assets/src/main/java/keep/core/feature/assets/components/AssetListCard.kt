package keep.core.feature.assets

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyBitcoin
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import keep.core.feature.assets.model.AssetUIState

@Composable
fun AssetListCard(
    asset: AssetUIState,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = asset.iconUrl,
                placeholder = painterResource(id = R.drawable.ic_100tb),
                contentDescription = "Asset Icon",
                modifier = Modifier.size(48.dp).padding(end = 16.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = asset.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Row {
                    Text(
                        text = asset.conversionPrice,
                        maxLines = 1,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = asset.conversionChanges,
                        color = Color(asset.conversionChangesColor),
                        maxLines = 1,
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(text = asset.amount, maxLines = 1,)
                Text(text = asset.conversionAmount, maxLines = 1,)
            }
        }
    }
}

@Preview("Asset list card")
@Preview("Asset list card", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAssetListCard() {
    MaterialTheme {
        AssetListCard(
            asset = AssetUIState(
                assetId = "btc_id",
                iconUrl = "someUrl",
                title = "Bitcoin",
                conversionPrice = "21 000$",
                conversionChanges = "+1.5%",
                conversionChangesColor = 0xFF10a033,
                amount = "10 BTC",
                conversionAmount = "210 000$"
            )
        )
    }
}
