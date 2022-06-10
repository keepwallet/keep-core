package keep.core.model

data class Account(
    val chain: Chain,
    val derivation: String,
    val address: Address,
)