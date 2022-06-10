package keep.core.model

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class TryNetworkQuery {

    suspend fun query(): String {
        val client = HttpClient()
        val response: HttpResponse = client.get("https://ktor.io/")
        return response.bodyAsText()
    }
}