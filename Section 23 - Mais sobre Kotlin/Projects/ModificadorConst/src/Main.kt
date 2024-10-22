// Top level declaration
// Para esse tipo de declaração, deverá ser constante (só funciona em Top levels ou estático (object)).
// Só aceitam valores constantes, antes do tempo de compilação e execução.

const val CONST_1 = 2004
const val CONST_2 = 2005

private class Classe {
    companion object {
        const val NUMBER = 3
    }

    object InsideObjects {
        const val LETTER = 'B'
    }
}

fun main() {
    println(CONST_1)
    println(CONST_2)
    println(Classe.NUMBER)
    println(Classe.InsideObjects.LETTER)
}