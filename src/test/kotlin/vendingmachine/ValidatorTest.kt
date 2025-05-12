package vendingmachine

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun `throws exception when coin amount is not integer or null`() {
        assertThrows<IllegalArgumentException> { validator.isCoinAmountValid("abc") }
    }

    @Test
    fun `throws exception when coin amount is a negative number`() {
        assertThrows<IllegalArgumentException> { validator.isCoinAmountValid("-1000") }
    }

    @Test
    fun `throws exception when coin amount is not divisible by 10`() {
        assertThrows<IllegalArgumentException> { validator.isCoinAmountValid("999") }
    }

    @Test
    fun `accepts coin amount with extra spaces`() {
        val result = validator.isCoinAmountValid("  500  ")
        assertEquals(500, result) }

    @Test
    fun `returns number when coin amount is valid`() {
        val result = validator.isCoinAmountValid("450")
        assertEquals(450, result) }
}