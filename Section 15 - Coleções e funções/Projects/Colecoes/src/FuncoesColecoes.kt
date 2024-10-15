fun main() {
    val data = gerarDados()

    // any & count
    with(data) {
        println("Existe pelo menos um elemento? ${any()}")
        println("Número de itens na coleção: ${count()}")
    }

    // first & last
    with(data) {
        val primeiraReceita = firstOrNull()
        val ultimaReceita = lastOrNull()

        println("Primeiro elemento: ${primeiraReceita?.nome}.")
        println("Último elemento: ${ultimaReceita?.nome}.")
    }

    // sum & sumOf
    with(listOf(3, 6, 2023, 17, 1, 5, 23, 2004, 2005)) {
        val soma = sum()
        println("Resultado da soma: $soma")
    }
    with(data) {
        val totalCalorias = sumOf { it.calorias }
        println("Total de calorias de todas as receitas: $totalCalorias")
    }

    // filter
    with(data) {
        val receitasMenos1000Calorias = filter { it.calorias < 1000 }
        val receitasSemIngredientes = filter { it.ingredientes.isEmpty() }
        val existeLasanhaNaLista = any { it.nome == "Lasanha" }
        val quantidadeReceitasAltamenteCaloricas = count { it.calorias > 1000 }

        println("Receitas com menos de mil calorias:")
        for (receita in receitasMenos1000Calorias)
            println("\t> ${receita.nome}")

        println("Receitas sem ingredientes:")
        for (receita in receitasSemIngredientes)
            println("\t> ${receita.nome}")

        println("Existe lasanha na lista de receitas: $existeLasanhaNaLista")
        println("Quantidade de receitas altamente calóricas: $quantidadeReceitasAltamenteCaloricas")
    }

    // take & takelast
    with(data) {
        val duasPrimeirasReceitas = take(2)
        val tresUltimasReceitas = takeLast(3)

        println("Duas primeiras receitas:")
        for (receita in duasPrimeirasReceitas)
            println("\t> ${receita.nome}")

        println("Três últimas receitas:")
        for (receita in tresUltimasReceitas)
            println("\t> ${receita.nome}")
    }

    // forEach
    with(data) {
        forEach {
            val nome = it.nome
            val calorias = it.calorias

            println("$nome ($calorias calorias)")
        }
    }

    // max & min
    with(listOf(15, 7, 8, 9, 4, 3, 5)) {
        val maiorNumero = max()
        val menorNumero = min()

        println("Maior número: $maiorNumero")
        println("Menor número: $menorNumero")
    }
    with(data) {
        val maiorNumeroCalorias = maxOfOrNull { it.calorias }
        val menorNumeroCalorias = minOfOrNull { it.calorias }
        val receitaMaisCalorica = maxByOrNull { it.calorias }
        val receitaMenosCalorica = minByOrNull { it.calorias }

        println("Maior número de calórias: $maiorNumeroCalorias")
        println("Menor número de calórias: $menorNumeroCalorias")
        println("Receita mais calórica: ${receitaMaisCalorica?.nome}")
        println("Receita menos calórica: ${receitaMenosCalorica?.nome}")
    }

    // map
    with(data) {
        val nomesReceitas = map { it.nome }
        val receitasSemIngredientes = map { Receita(it.nome, it.calorias) }

        println("Nome das receitas:")
        nomesReceitas.forEach {
            println("\t> $it.")
        }

        println("Receitas sem ingredientes:\n\t$receitasSemIngredientes")
    }

    // average
    with(data.map { it.calorias }) {
        val mediaCaloriasReceitas = average()
        println("Média de calórias das receitas: $mediaCaloriasReceitas")
    }

    // distinct, sorted & reversed
    with(listOf("Juan", "Bárbara", "Juan", "Maria", "Eduarda", "Maria")) {
        val listaDistinta = distinct()
        val nomesCrescentes = listaDistinta.sorted()
        val nomesDecrescentes = listaDistinta.sortedDescending()
        val listaDistintaReversa = listaDistinta.reversed()

        println("Lista:\n\t$this")
        println("Lista distinta:\n\t$listaDistinta")
        println("Nomes crescentes:\n\t$nomesCrescentes")
        println("Nomes decrescentes:\n\t$nomesDecrescentes")
        println("Lista distinta reversa:\n\t$listaDistintaReversa")
    }
}

private fun gerarDados(): List<Receita> {
    return listOf(
        Receita(
            nome = "Lasanha",
            calorias = 1200,
            ingredientes = listOf(
                Ingrediente(
                    nome = "Presunto",
                    quantidade = 3,
                ),
            ),
        ),
        Receita(
            nome = "Panqueca",
            calorias = 500
        ),
        Receita(
            nome = "Omelete",
            calorias = 200
        ),
        Receita(
            nome = "Parmegiana",
            calorias = 700
        ),
        Receita(
            nome = "Sopa de feijão",
            calorias = 300
        ),
        Receita(
            nome = "Hamburguer",
            calorias = 2000,
            ingredientes = listOf(
                Ingrediente(
                    nome = "Pão",
                    quantidade = 1
                ),
                Ingrediente(
                    nome = "Hamburguer",
                    quantidade = 1
                ),
                Ingrediente(
                    nome = "Queijo",
                    quantidade = 1
                ),
                Ingrediente(
                    nome = "Catupiry",
                    quantidade = 1
                ),
                Ingrediente(
                    nome = "Bacon",
                    quantidade = 3
                ),
                Ingrediente(
                    nome = "Alface",
                    quantidade = 1
                ),
                Ingrediente(
                    nome = "Tomate",
                    quantidade = 1
                )
            )
        )
    )
}

private data class Receita(
    val nome: String,
    val calorias: Int,
    val ingredientes: List<Ingrediente> = listOf()
)

private data class Ingrediente(
    val nome: String,
    val quantidade: Int
)