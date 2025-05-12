package vendingmachine

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CoinTest : NsTest() {

	@Test
	fun `exchange coin test1 - given number should be device by coin's type and print the result`() {
		run("5000")
		assertThat(output()).contains(
			"Coins in the vending machine:",
			"500 KRW - 10",
			"100 KRW - 0",
			"50 KRW - 0",
			"10 KRW - 0",
		)
	}

	@Test
	fun `exchange coin test2 - given number should be device by coin's type and print the result`() {
		run("3820")
		assertThat(output()).contains(
			"Coins in the vending machine:",
			"500 KRW - 7",
			"100 KRW - 3",
			"50 KRW - 0",
			"10 KRW - 2",
		)
	}


	override fun runMain() {
		main()
	}

}