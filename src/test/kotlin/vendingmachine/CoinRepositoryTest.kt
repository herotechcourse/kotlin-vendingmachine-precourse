package vendingmachine

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

class CoinRepositoryTest {
	@Test
	@DisplayName("generates valid coin repository")
	fun generateValidCoinRepository() {
		val coinRepo = CoinRepository(1000)
		assertThat(coinRepo.getBalance()).isEqualTo(1000)
	}
}