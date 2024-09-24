// a. Crie um novo arquivo com uma função main.

fun main() {
    // b. Declare uma variável mutável, capaz de armazenar seu nome completo.
    val nomeCompleto = "Juan Felipe Alves Flores"
    println("Nome completo: $nomeCompleto")

    // c. Declare uma variável de texto, sem valor algum.
    var texto : String

    // d. Declare uma variável imutável, com o menor tipo de dado possível, capaz de armazenar o núemro que você calça.
    val numeracaoCalcado : UByte = 43u
    println("Número do calçado: $numeracaoCalcado")

    // e. Declare uma variável capaz de armazenar o PIB do Brasil (1.869.000.000.000).
    val pibBrasil = 1869000000000.00
    println("PIB do Brasil: $pibBrasil")

    // f. Declare uma variável capaz de armazenar a população do Brasil (211.000.000).
    val populacaoBrasil = 211000000
    println("População do Brasil: $populacaoBrasil")

    // g. Imprima o valor do PIB per capita.
    val valorPibPerCapita : Double = pibBrasil / populacaoBrasil
    println("Valor do PIB per capita: R$ $valorPibPerCapita")
}