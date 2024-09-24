fun main() {
    val nome = "Juan Felipe"
    val sobrenome = "Alves Flores"

    // Interpolação
    val nomeCompleto = "$nome $sobrenome"

    println("Olá, $nomeCompleto. Seja bem-vindo.")
    println("Quantidade de caracteres do nome completo: ${nomeCompleto.length}")
}