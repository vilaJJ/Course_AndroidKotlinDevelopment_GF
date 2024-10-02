package controleWhile

/*
2. FizzBuzz. Imprima os números de 1 a 50, em ordem crescente, de acordo com a regra abaixo:

a. Quando um número for divisível por 3, imprimir Buzz.
b. Quando um número for divisível por 5, imprimir Fizz.
c. Quando um número for divisível por 3 e 5, imprimir FizzBuzz.
*/

fun main() {
    var i = 1

    while (i <= 50) {
        val isFizz = i % 5 == 0
        val isBuzz = i % 3 == 0
        val isFizzBuzz = isBuzz && isFizz

        if (isFizzBuzz) {
            println("FizzBuzz ($i)")
        } else if (isFizz) {
            println("Fizz ($i)")
        } else if (isBuzz) {
            println("Buzz ($i)")
        }

        i++
    }
}