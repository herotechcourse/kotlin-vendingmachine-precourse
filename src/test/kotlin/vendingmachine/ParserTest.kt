package vendingmachine

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import view.Parser.vendingMachineAmount

class ParserTest {
    @Test
    fun `Throw an error if vending machine amount is negative`() {
        assertThrows<IllegalArgumentException> {
            vendingMachineAmount("-1000")
        }
    }

    @Test
    fun `Throw an error if vending machine amount is empty`() {
        assertThrows<IllegalArgumentException> {
            vendingMachineAmount("")
        }
    }

    @Test
    fun `Throw an error if vending machine amount is not divisible by 10`() {
        assertThrows<IllegalArgumentException> {
            vendingMachineAmount("99999999999999")
        }
    }

    @Test
    fun `valid vending machine amount, the amount is 3000`() {
        assertEquals(vendingMachineAmount("3000"), 3000)
    }
}