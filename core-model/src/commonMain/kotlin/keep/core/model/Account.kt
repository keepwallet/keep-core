package keep.core.model

data class Account(
    val coin: Coin,
    val derivation: String,
    val address: Address,
)