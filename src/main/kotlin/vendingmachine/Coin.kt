package vendingmachine

import camp.nextstep.edu.missionutils.Randoms
import net.bytebuddy.dynamic.scaffold.TypeInitializer.None

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    companion object {
        fun generateCoin(amount: Int): Coin {
            while (true) {
                val coinValue = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
                if (amount >= coinValue) {
                    returnCoin(coinValue)
                }
            }
        }

        private fun returnCoin(value: Int): Coin {
            return when {
                value == 500 -> COIN_500
                value == 100 -> COIN_100
                value == 50 -> COIN_50
                else -> COIN_10
            }
        }
    }
}
