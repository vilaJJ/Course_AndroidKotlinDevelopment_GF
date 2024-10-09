fun main() {
    try {
        escreverTexto()

        val resultadoDivisao = dividir(15, 0)
        println(resultadoDivisao)
    } catch (e: NullPointerException) {
        println("Variável nula.")
    } catch (e: ArithmeticException) {
        println("Não é possível dividir por zero.")
    } catch (e: Exception) {
        println("Erro na execução: ${e.message}")
    } finally {
        println("Fim do programa.")
    }
}

fun escreverTexto() {
    print("Escreva algo: ")
    var texto: String? = readlnOrNull()

    if (texto == "") {
        texto = null
    }

    println("Tamanho do texto: ${texto!!.length}")
}

fun dividir(dividendo: Int, divisor: Int) =
    (dividendo / divisor)