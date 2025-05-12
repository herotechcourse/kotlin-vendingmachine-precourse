package vendingmachine.views

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

class InputViewTest {
	@Test
	@DisplayName("parses valid coin sum")
	fun parseValidCoinSum() {
		assertThat(InputView.parseCoinSum("2000")).isEqualTo(2000)
	}

	@Test
	@DisplayName("parseCoinSum with non-numeric input throws exception")
	fun parseNonNumericCoinSumThrows() {
		assertThatThrownBy { InputView.parseCoinSum("abc") }
			.isInstanceOf(IllegalArgumentException::class.java)
			.hasMessageContaining("[ERROR]")
	}

	@Test
	@DisplayName("parseCoinSum with non integer input throws exception")
	fun parseNonIntegerCoinSumThrows() {
		assertThatThrownBy { InputView.parseCoinSum("1.5") }
			.isInstanceOf(IllegalArgumentException::class.java)
			.hasMessageContaining("[ERROR]")
	}

	@Test
	@DisplayName("parseCoinSum with less than zero throws exception")
	fun parseLessThanZeroCoinSumThrows() {
		assertThatThrownBy { InputView.parsePurchaseAmount("=-1") }
			.isInstanceOf(IllegalArgumentException::class.java)
			.hasMessageContaining("[ERROR]")
	}

	@Test
	@DisplayName("parseCoinSum with non-positive multiple of minimum coin sum throws exception")
	fun parseInvalidMultiplePurchaseAmountThrows() {
		assertThatThrownBy { InputView.parsePurchaseAmount("5") }
			.isInstanceOf(IllegalArgumentException::class.java)
			.hasMessageContaining("[ERROR]")
	}

	@Test
	@DisplayName("parses valid single product inventory")
	fun parseValidSingleProductInventory() {
		assertThat(InputView.parseProductInventory("[Cola,1500,20]")).isEqualTo(listOf("[Cola,1500,20]"))
	}

	@Test
	@DisplayName("parses valid multiple product inventory")
	fun parseValidMultipleProductInventory() {
		assertThat(InputView.parseProductInventory("[Cola,1500,20];[Soda,1000,10]")).isEqualTo(
			listOf("[Cola,1500,20]", "[Soda,1000,10]")
		)
	}

	@Test
	@DisplayName("parseProductInventory with invalid input throws exception")
	fun parseInvalidProductInventory() {
		assertThatThrownBy { InputView.parsePurchaseAmount("[Cola,1500,20") }
			.isInstanceOf(IllegalArgumentException::class.java)
			.hasMessageContaining("[ERROR]")
	}



}