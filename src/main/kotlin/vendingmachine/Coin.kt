package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),

    fun generate(amount: Int): List<List<Int>> {
            while (amount >= 10) {
                val remaining = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
                if (remaining >= amount) {
                    remaining -= amount
                }
            }
    }

    // TODO: Implement additional functions
}
