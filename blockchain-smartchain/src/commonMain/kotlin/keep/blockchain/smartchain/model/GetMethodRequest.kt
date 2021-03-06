package keep.blockchain.smartchain.model

import kotlinx.serialization.Serializable

@Serializable
data class MethodRequest(
    val id: Int,
    val jsonrpc: String,
    val method: String,
    val params: List<String>
)