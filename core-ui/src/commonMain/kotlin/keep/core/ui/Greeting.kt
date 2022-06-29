package keep.core.ui

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}