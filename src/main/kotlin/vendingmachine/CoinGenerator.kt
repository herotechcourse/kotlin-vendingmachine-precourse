package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

object CoinGenerator {
    fun issue(remaining: Int): Map<Coin, Int> {
        var temp = remaining
        val map = mutableMapOf(Coin.COIN_500 to 0, Coin.COIN_100 to 0, Coin.COIN_50 to 0, Coin.COIN_10 to 0)
        while (temp >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (temp >= amount) {
                temp -= amount
                println(amount)
                val key: Coin = Coin.entries.find { it.amount == amount } ?: Coin.COIN_10
                map[key] = map.getValue(key) + 1
            }
        }
        return map
    }
}