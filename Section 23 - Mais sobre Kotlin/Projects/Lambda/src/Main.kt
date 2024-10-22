// Lambda -> Função anônima: pode ser passada por função.
// { parameters -> body }

fun main() {
    lambdaWithoutParameters()
    lambdaWithParameters()
    passLambdaInFunction()
}

private fun lambdaWithoutParameters() {
    val lambda = { println("Hello World!") }
    lambda()
}

private fun lambdaWithParameters() {
    val square = { x: Int -> x * x }
    val multiply = { x: Int, y: Int -> x * y }

    println(square(6))
    println(multiply(17, 23))
}

// (parameters) -> return type
private fun passLambdaInFunction() {
    val division = { x: Int, y: Int -> x / y }
    val subtractResult = receiveNumbers { x: Int, y: Int -> x - y }

    println(receiveNumbers(division))
    println(subtractResult)
}

private fun receiveNumbers(action: (x: Int, y: Int) -> Int): Int {
    return action(10, 5)
}
