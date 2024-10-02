package controleFor

/*
5. Escreva um programam capaz de receber um número inteiro N e imprimir uma escada de tamanho N, usando o caracter #.

Se a entrada do programa for 3, teremos:                Se a entrada do programa for 5, teremos:
#                                                       #
##                                                      ##
###                                                     ###
                                                        ####
                                                        #####
*/

fun main() {
    print("Insira a quantidade: ")
    val quantidadeLeitura = readlnOrNull()

    if (quantidadeLeitura.isNullOrEmpty()) {
        println("A quantidade informada é inválida.")
        return
    }

    val quantidade = quantidadeLeitura.toInt()

    for (i in 0..quantidade) {
        var linha = ""

        for (j in 0..i) {
            linha += '#'
        }

        println(linha)
    }
}