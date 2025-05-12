package vendingmachine

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {
    @Test
    fun `feature test`() {
        assertRandomNumberInListTest(
            {
                run("450", "[Cola,1500,20];[Soda,1000,10]", "3000", "Cola", "Soda")
                assertThat(output()).contains(
                    "Coins in the vending machine:",
                    "500 KRW - 0",
                    "100 KRW - 4",
                    "50 KRW - 1",
                    "10 KRW - 0",
                    "Inserted amount: 3000 KRW",
                    "Inserted amount: 1500 KRW",
                )
            },
            100,
            100,
            100,
            100,
            50,
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            runException("-1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
