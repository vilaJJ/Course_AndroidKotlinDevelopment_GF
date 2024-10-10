import org.example.apresentarMomentoDoDia
import org.example.countXO
import org.example.estourarExcecao
import org.example.realizarContagem
import org.junit.jupiter.api.*

class MainTest {
    @Test
    @DisplayName("Método para apresentar o momento do dia")
    fun testApresentarMomentoDoDia() {
        Assertions.assertAll(
            { Assertions.assertEquals(apresentarMomentoDoDia(11u), "Manhã") },
            { Assertions.assertEquals(apresentarMomentoDoDia(14u), "Tarde") },
            { Assertions.assertEquals(apresentarMomentoDoDia(20u), "Noite") },
            { Assertions.assertEquals(apresentarMomentoDoDia(3u), "Madrugada") },
        )
    }

    @Test
    @DisplayName("Método de verificar X e O iguais")
    fun testCountXO() {
        Assertions.assertAll(
            { Assertions.assertTrue(countXO("xxoo")) },
            { Assertions.assertTrue(countXO("XxOo")) },
            { Assertions.assertFalse(countXO("xxox")) },
            { Assertions.assertFalse(countXO("OxOo")) }
        )
    }

    @Test
    @Disabled
    @DisplayName("Não implementado")
    fun naoImplementado() {
    }

    @Test
    fun vaiFalhar() {
        fail("Não posso terminar os testes sem a implementação deste método.")
    }

    @Test
    @DisplayName("Executar apenas se a suposição for verdadeira.")
    fun assumption() {
        Assumptions.assumeTrue(countXO("xxoxxoo"))
        Assertions.assertTrue(realizarContagem())
    }

    @Test
    fun exception() {
        assertThrows<NullPointerException> { estourarExcecao() }
    }
}