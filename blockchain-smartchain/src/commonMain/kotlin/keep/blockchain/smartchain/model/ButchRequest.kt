package keep.blockchain.smartchain.model

import kotlinx.serialization.Serializable

@Serializable
data class ButchRequest(
    val id: Int,
    val jsonrpc: String,
    val method: String,
    val params: Array<String>
)