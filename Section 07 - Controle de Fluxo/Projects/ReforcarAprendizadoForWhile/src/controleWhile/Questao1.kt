package controleWhile

/*
1. Considere uma caixa d'água de 2 mil litros. Rômulo gostaria de encher a cadixa d'água com balões de água de 7 litros.
Quantos balões cabem na caixa d'água sem que o volume seja excedido?
*/

fun main() {
    val capacidadeMaximaLitros = 2000
    val tamanhoBalaoLitros = 7

    var quantidadeBaloes = 0
    var volumeAtualCaixa = 0

    while (true) {
        if (volumeAtualCaixa + tamanhoBalaoLitros >= capacidadeMaximaLitros) {
            break
        }

        quantidadeBaloes++
        volumeAtualCaixa += tamanhoBalaoLitros
    }

    println("São necessários $quantidadeBaloes balões para encher a caixa d'água sem exceder seu volume.")
    println("Volume de água atual: $volumeAtualCaixa litros.")
}