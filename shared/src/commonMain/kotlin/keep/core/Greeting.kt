package keep.core

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}