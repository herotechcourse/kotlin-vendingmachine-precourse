package vendingmachine.model

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin

class CoinsGenerator (val amount: Int){

    private fun generateCoins(): MutableList<Int> {
        var remaining = this.amount
        val possibleCoins: MutableList<Int> = mutableListOf()
        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount
                possibleCoins.add(amount)
            }
        }
        return possibleCoins
    }

    fun createCoins(): MutableMap<Coin, Int> {
        val coinCounts = initializeCoins()
        val possibleCoins = generateCoins()
        possibleCoins.forEach { value ->
            val coin  = Coin.from(value)
            coinCounts[coin] = coinCounts.getValue(coin) + 1
        }
        return coinCounts
    }

    private fun initializeCoins(): MutableMap<Coin, Int> {
        val coinCounts = mutableMapOf<Coin, Int>()
        for (coin in Coin.entries) {
            coinCounts[coin] = 0
        }
        return coinCounts
    }

}