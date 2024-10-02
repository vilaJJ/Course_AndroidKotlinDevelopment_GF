package controleFor

// 3. Usando a resolução do exercício 1, não imprima os números múltiplos de 5.

fun main() {
    for (i in 1..50) {
        if (i % 5 == 0) {
            continue
        }
        print("$i ")
    }
}