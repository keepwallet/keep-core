package keep.blockchain.smartchain.model

data class CallRequest(
    val from: String,
    val to: String,
    val data: String,
)