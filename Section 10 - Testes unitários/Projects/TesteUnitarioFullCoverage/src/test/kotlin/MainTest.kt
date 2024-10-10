import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    @DisplayName("Realizar a ação de portaria")
    fun testRealizarPortaria() {
        Assertions.assertAll(
            { Assertions.assertTrue(realizarPortaria(19u, 2, "XL1356")) },
            { Assertions.assertFalse(realizarPortaria(17u, 1, "XL1678")) },
            { Assertions.assertTrue(realizarPortaria(25u, 1, "XT6805")) },
            { Assertions.assertFalse(realizarPortaria(21u, 4, "XL1356")) },
            { Assertions.assertTrue(realizarPortaria(32u, 3, "XL2305")) },
            { Assertions.assertFalse(realizarPortaria(18u, 1, "XL1701")) },
        )
    }

    @Test
    @DisplayName("Verificar se o tipo de convite é válido")
    fun testIsTipoConviteValido() {
        Assertions.assertAll(
            { Assertions.assertTrue(isTipoConviteValido(3)) },
            { Assertions.assertFalse(isTipoConviteValido(7)) },
            { Assertions.assertTrue(isTipoConviteValido(1)) },
            { Assertions.assertFalse(isTipoConviteValido(4)) },
            { Assertions.assertTrue(isTipoConviteValido(2)) },
            { Assertions.assertFalse(isTipoConviteValido(0)) },
        )
    }

    @Test
    @DisplayName("Verificar se o codigo do convite é válido")
    fun testIsCodigoConviteValido() {
        Assertions.assertAll(
            { Assertions.assertTrue(isCodigoConviteValido(1, "XT1324")) },
            { Assertions.assertFalse(isCodigoConviteValido(1, "XL2834")) },
            { Assertions.assertTrue(isCodigoConviteValido(2, "XL2384")) },
            { Assertions.assertFalse(isCodigoConviteValido(2, "XT4871")) },
            { Assertions.assertTrue(isCodigoConviteValido(3, "XL8952")) },
            { Assertions.assertFalse(isCodigoConviteValido(3, "XT1515")) },
            { Assertions.assertTrue(isCodigoConviteValido(1, "XT1574")) },
            { Assertions.assertFalse(isCodigoConviteValido(4, "XL1234")) },
        )
    }
}