package desafio

/*
Ana e Paula são duas programadoras da empresa XDM. A empresa XDM possui um benefício para incentivar os funcionários a
pouparem dinheiro para a aposentadoria que funciona da seguinte maneira:
    - Se o funcionário destinar 5% do seu salário para o investimento, a empresa acrescenta o mesmo valor. Ou seja,
      caso o funcionário invista 100 reais, a empresa investe mais 100. Este fundo de investimento possui rendimento de
      0,2% ao mês.

Ana adorou a ideia e vai investir. No entanto, Paula decidiu que vai investir os mesmos 5% por conta própria já que
conhece investimentos que rendem mais que 0,2% ao mês. Paula vai escolher investimentos que rendem 0,8% ao mês.

Considere o salário de Ana e Paula iguais e no valor de 10 mil reais e que as duas estão começando com saldo 0 e que
investirão 5% do salário.

Em quantos meses o patrimônio de Paula vai superar o patrimônio de Ana?
*/

const val percentualSalarioInvestir = 0.05f

fun main() {
    val salario = 10000f

    var investimentoAna = 0f
    var investimentoPaula = 0f

    var quantidadeMeses = 0

    while (true) {
        investimentoAna = realizarRendimentoMensalEmpresa(salario, investimentoAna)
        investimentoPaula = realizarRendimentoMensalPrivada(salario, investimentoPaula)

        if (investimentoPaula > investimentoAna) {
            break
        }

        quantidadeMeses++
    }

    println("Foram necessários $quantidadeMeses meses para o investimento de Paula superar o investimento de Ana.")
}

fun realizarRendimentoMensalEmpresa(salarioAtual: Float, valorAtualInvestido: Float): Float {
    val rendimentoMensalEmpresa = 0.002f

    val rendimento = valorAtualInvestido * rendimentoMensalEmpresa
    val parteSalario = (salarioAtual * percentualSalarioInvestir) * 2

    val novoValorInvestido = valorAtualInvestido + rendimento + parteSalario
    return novoValorInvestido
}

fun realizarRendimentoMensalPrivada(salarioAtual: Float, valorAtualInvestido: Float): Float {
    val rendimentoMensalPrivado = 0.008f

    val rendimento = valorAtualInvestido * rendimentoMensalPrivado
    val parteSalario = salarioAtual * percentualSalarioInvestir

    val novoValorInvestido = valorAtualInvestido + rendimento + parteSalario
    return novoValorInvestido
}