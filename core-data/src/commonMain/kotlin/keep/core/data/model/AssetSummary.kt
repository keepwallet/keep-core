package keep.core.data.model

import keep.core.data.Balances
import keep.core.model.Account
import keep.core.model.Asset
import keep.core.model.Ticker

data class AssetSummary(
    val asset: Asset,
    val account: Account? = null,
    val balances: Balances = emptyList(),
    val ticker: Ticker? = null,
)