import funcoes.*

fun main() {
    detalharQuantidadeAnos(20u)

    val quantidadeCaracteres = obterQuantidadeCaracteres("Linguagem Kotlin")
    val calculoCubo = calcularCubo(8)
    val valorKm = converterMilhasParaKm(158.6f)

    println("Quantidade de caracteres: $quantidadeCaracteres")
    println("Cálculo do cubo: $calculoCubo")
    println("Valor em km: $valorKm")

    exibirTextoTrocadandoAporX("Juan Felipe Alves Flores")
}