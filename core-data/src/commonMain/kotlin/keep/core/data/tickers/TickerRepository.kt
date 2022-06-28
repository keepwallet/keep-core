package keep.core.data.tickers

import keep.core.data.model.Session
import keep.core.model.Asset
import keep.core.model.Ticker

interface TickerRepository {
    suspend fun getTicker(asset: Asset): Ticker

    suspend fun setTicker(asset: Asset, ticker: Ticker): Boolean

    fun setOnTickersListener(listener: OnTickersListener)
}

interface OnTickersListener {
    fun onTickersChange()
}