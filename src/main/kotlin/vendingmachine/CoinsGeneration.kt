package vendingmachine

import  camp.nextstep.edu.missionutils.Randoms

class Coins {
    fun generate(numberOfCoins: String): List<Coin> {
        val remaining = numberOfCoins.toInt()
        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount


            }
        Coin(remaining)
        }
    }
}
