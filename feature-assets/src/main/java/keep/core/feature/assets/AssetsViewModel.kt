package keep.core.feature.assets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ionspin.kotlin.bignum.integer.BigInteger
import keep.core.data.assets.AssetsRepository
import keep.core.data.model.AssetSummary
import keep.core.data.session.SessionRepository
import keep.core.feature.assets.model.AssetUIState
import keep.core.feature.assets.model.AssetsHeadUIState
import keep.core.feature.assets.model.AssetsUIState
import keep.core.model.KeepError
import keep.core.model.total
import keep.core.ui.theme.Green
import keep.core.ui.theme.Red700Val
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AssetsViewModel(
    val assetsRepository: AssetsRepository,
    val sessionRepository: SessionRepository,
) : ViewModel() {
    private val viewModelState = MutableStateFlow(ViewModelState(true))
    val uiState = viewModelState
        .map { it.mapToUIState() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = viewModelState.value.mapToUIState()
        )

    init {
        refresh()
    }

    fun onAssetClick(assetId: String) {

    }

    fun onAssetAction(assetId: String, action: AssetsScreenItemAction) {

    }

    private fun onDelete(assetId: String) {

    }

    private fun onReceive(assetId: String) {

    }

    private fun onTransfer(assetId: String) {

    }

    private fun onTrade(assetId: String) {

    }

    private fun refresh() {
        viewModelState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val session = sessionRepository.current()
            val assets = assetsRepository.getAssets()
            val walletName = session.wallet.title
            val walletConversionAmount = calculateWalletConversionAmount(assets).toString() // TODO: Add formatting: iOs and Android
            viewModelState.update {
                it.copy(
                    isLoading = false,
                    assets = assets,
                    walletName = walletName,
                    walletConversionAmount = walletConversionAmount
                )
            }
        }
    }

    private fun calculateWalletConversionAmount(assets: List<AssetSummary>) = assets.map {
        val chain = it.account?.chain ?: return@map 0.0
        val total = it.balances.total(chain)
        val price = try {
            it.ticker?.price?.toDouble() ?: return@map 0.0
        } catch (err: Throwable) {
            return@map 0.0
        }
        if (total.compare(BigInteger.ZERO) < 1) {
            0.0
        } else {
            price * total.doubleValue() // TODO: Convert to human readable: iOs and Android
        }
    }.fold(0.0) { acc, element -> acc + element }
}

private data class ViewModelState (
    val isLoading: Boolean = false,
    val errors: List<KeepError> = emptyList(),

    val assets: List<AssetSummary> = emptyList(),
    val walletName: String = "",
    val walletConversionAmount: String = "",
) {
    fun mapToUIState(): AssetsScreenUIState = when {
        !isLoading && assets.isEmpty() -> AssetsScreenUIState.Empty(errors = errors)
        assets.isNotEmpty() -> {
            val assets = assets.mapNotNull {
                val chain = it.account?.chain ?: return@mapNotNull null
                val totalBalance = it.balances.total(chain)
                // TODO: Convert total value to human readable and convert to conversion value
                val conversionTotal = (it.ticker?.price?.toDouble() ?: 0.0) * totalBalance.doubleValue()
                AssetUIState(
                    assetId = it.asset.id,
                    iconUrl = "", // TODO: Add iconUrl processing to AssetsRepository
                    title = it.asset.name,
                    conversionPrice = it.ticker?.price ?: "",
                    conversionChanges = it.ticker?.percentChange24h?.toString() ?: "",
                    conversionChangesColor = if ((it.ticker?.percentChange24h ?: 0.0) < 0.0) {
                        Green
                    } else {
                        Red700Val
                    },
                    amount = totalBalance.toString(), // TODO: Add formatting
                    conversionAmount = conversionTotal.toString(), // TODO: Add formatting
                )
            }
            AssetsScreenUIState.Assets(
                assets = AssetsUIState(
                    head = AssetsHeadUIState(walletName, totalConversionAmount = walletConversionAmount),
                    assets = assets,
                ),
                isLoading = isLoading,
                errors = errors,
            )
        }
        else -> AssetsScreenUIState.Loading
    }
}

sealed interface AssetsScreenUIState {
    object Loading : AssetsScreenUIState

    data class Empty(
        val errors: List<KeepError> = emptyList(),
    ) : AssetsScreenUIState

    data class Assets(
        val errors: List<KeepError> = emptyList(),
        val isLoading: Boolean = false,
        val assets: AssetsUIState,
    ) : AssetsScreenUIState
}

// TODO: Rename or (and) move to special model
enum class AssetsScreenItemAction {
    Delete,
    Transfer,
    Receive,
    Trade,
}