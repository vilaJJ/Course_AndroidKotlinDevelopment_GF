class Implementation {
    private val name = "Kotlin"

    fun main() {
        // SAM Conversion (Single Abstract Method): Funciona em Java quando as interfaces possuem apenas um método.
        Form().clickJava {
            println("Hello, Java! Name is $name")
        }

        Form().clickKotlin(object : EventListenerKotlin {
            override fun click() {
                println("Hello, Kotlin!")
            }
        })
    }
}