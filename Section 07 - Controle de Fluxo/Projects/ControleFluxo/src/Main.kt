fun main() {
    verificarIdade(20u)
    verificarIdadeRange(17u)

    println(realizarSaudacao(false))
    println(realizarSaudacao(true))

    val bonusFuncionario = bonusWhen(2)
    println("O seu bônus será de R$ $bonusFuncionario.")
}

fun verificarIdade(idade: UByte) {
    if (idade < 3u) {
        println("É um bebê.")
    } else if (idade < 13u) {
        println("É uma criança.")
    } else if (idade < 15u) {
        println("É um pré-adolescente.")
    } else if (idade < 18u) {
        println("É um adolescente.")
    } else if (idade < 25u) {
        println("É um jovem adulto")
    } else if (idade < 60u) {
        println("É um adulto.")
    } else {
        println("É um idoso.")
    }
}

fun verificarIdadeRange(idade: UByte) {
    when (idade) {
        in 0u..2u -> println("É um bebê.")
        in 3u..12u -> println("É um criança.")
        in 13u..14u -> println("É um pré-adolescente.")
        in 15u..17u -> println("É um adolescente.")
        in 18u..24u -> println("É um jovem adulto.")
        in 25u..59u -> println("É um adulto.")
        else -> println("É um idoso")
    }
}

fun realizarSaudacao(isDia: Boolean) = if (isDia) {
    "Bom dia."
} else {
    "Boa noite."
}

/*
* ID            Tipo                    Bônus           Adicional
* 1             Gerente                 R$ 2.000,00     + R$ 1.000,00 para 2 anos de exp. ou mais
* 2             Coordenador             R$ 1.500,00     + R$ 300,00 para 1 ano de exp. ou mais
* 3             Engenheiro de software  R$ 1.000,00
* 4             Estagiário              R$ 500,00
* */
fun calcularBonusFuncionarioFinalDeAno(cargoId: Int, anosExperiencia: UByte): Float {
    var valorBonus: Float

    if (cargoId == 1) {
        valorBonus = 2000f

        if (anosExperiencia >= 2u) {
            valorBonus += 1000
        }
    } else if (cargoId == 2) {
        valorBonus = 1500f

        if (anosExperiencia >= 1u) {
            valorBonus += 300
        }
    } else if (cargoId == 3) {
        valorBonus = 1000f
    } else if (cargoId == 4) {
        valorBonus = 500f
    } else {
        valorBonus = 0f
    }

    return valorBonus
}

fun bonusWhen(cargoId: Int): Float {
    return when (cargoId) {
        1 -> 2000f
        2 -> 1500f
        3 -> 1000f
        4 -> 500f
        else -> 0f
    }
}