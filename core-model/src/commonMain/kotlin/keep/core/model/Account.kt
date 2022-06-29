package keep.core.model

data class Account(
    val chain: Chain,
    val address: Address,
    val derivationIndex: Int,
    val title: String,
)