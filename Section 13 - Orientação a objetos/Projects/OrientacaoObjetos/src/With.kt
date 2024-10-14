fun main() {
    val pessoa = Pessoa("Juan Felipe", 2004u)

    with(pessoa) {
        acordar()
        dormir()
    }
}