fun main() {
    for (i in 1..10) {
        println("Repetição nº $i")
    }

    for (i in 1..10 step 2) {
        println("Repetição pulando de 2 em 2 nº $i")
    }

    for (i in 20 downTo 0) {
        println("Repetiçao decrescente nº $i")
    }

    for (i in 20 downTo 0 step 4) {
        println("Repetição decrescente pulando de 4 em 4 nº $i")
    }

    val nome = "Juan Felipe"

    for (char in nome) {
        print("[$char]")
    }
}