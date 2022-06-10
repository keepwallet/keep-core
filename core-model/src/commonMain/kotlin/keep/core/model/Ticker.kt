package keep.core.model

data class Ticker(
    val price: String,
    val symbol: String,
    val currencyCode: String,
    val percentChange24h: Double,
)