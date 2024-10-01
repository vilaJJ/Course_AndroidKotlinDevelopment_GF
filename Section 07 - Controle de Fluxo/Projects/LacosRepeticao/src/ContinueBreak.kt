fun main() {
    var i = 0
    while (true) {
        i++

        if (i == 43) {
            break
        }
        if (i % 2 == 0) {
            continue
        }

        println("Verdadeiro [$i]")
    }
}