fun main() {
    val bonusGerenteMaisExp = calcularBonusFuncionarioFinalDeAno(1, 4u)
    val bonusGerenteMenosExp = calcularBonusFuncionarioFinalDeAno(1, 1u)
    val bonusCoordenadorMaisExp = calcularBonusFuncionarioFinalDeAno(2, 5u)
    val bonusCoordenadorMenosExp = calcularBonusFuncionarioFinalDeAno(2, 0u)
    val bonusEngenheiroSoftware = calcularBonusFuncionarioFinalDeAno(3, 2u)
    val bonusEstagiario = calcularBonusFuncionarioFinalDeAno(4, 0u)

    println("Bônus do gerente mais experiente: R$ $bonusGerenteMaisExp")
    println("Bônus do gerente menos experiente: R$ $bonusGerenteMenosExp")
    println("Bônus do coordenador mais experiente: R$ $bonusCoordenadorMaisExp")
    println("Bônus do coordenador menos experiente: R$ $bonusCoordenadorMenosExp")
    println("Bônus do engenheiro de software: R$ $bonusEngenheiroSoftware")
    println("Bônus do estagiário: R$ $bonusEstagiario")
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