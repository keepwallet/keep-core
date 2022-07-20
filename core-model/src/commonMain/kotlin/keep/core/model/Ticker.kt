package keep.core.model

data class Ticker(
    val price: Double,
    val symbol: String,
    val currencyCode: String,
    val percentChange24h: Double,
)