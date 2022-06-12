package keep.core.crypto

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}