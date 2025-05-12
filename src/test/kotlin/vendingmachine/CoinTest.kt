package vendingmachine

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

class CoinTest {
	@Test
	@DisplayName("valid random coin value")
	fun validRandomCoinValue() {
		assert(Coin.randomCoinValue() in setOf(10, 50, 100, 500))
	}
}