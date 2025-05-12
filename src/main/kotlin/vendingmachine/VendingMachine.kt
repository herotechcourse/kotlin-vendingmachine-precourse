package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class VendingMachine {
    fun initialCoinsInMachine(initialAmount : Int): MutableMap<Int, Int>
    {
        //val coinMap = mutableMapOf(500 to 0, 100 to 0, 50 to 0, 10 to 0)
        val coinMap = mutableMapOf(Coin.COIN_500.amount to 0, Coin.COIN_100.amount to 0, Coin.COIN_50.amount to 0, Coin.COIN_10.amount to 0)
        println(coinMap.entries)
        var remaining = initialAmount
        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount
                val value = coinMap.getValue(amount)
                coinMap[amount] = value + 1
            }
        }
        return coinMap
    }
}