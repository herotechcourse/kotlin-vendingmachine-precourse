package vendingmachine

import camp.nextstep.edu.missionutils.Randoms
import kotlin.enums.enumEntries

class VendingMachine {

    fun initialCoinsInMachine(initialAmount : Int): MutableMap<Int, Int>
    {
        val coinMap = mutableMapOf(Coin.COIN_500.amount to 0, Coin.COIN_100.amount to 0, Coin.COIN_50.amount to 0, Coin.COIN_10.amount to 0)
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

    fun changeReturned(initialAmount: Int ,remainingAmount: Int,initialCoinMap : MutableMap<Int, Int>) : MutableMap<Int, Int> {
        var remaining = remainingAmount
        val changeCoinMap = mutableMapOf(Coin.COIN_500.amount to 0, Coin.COIN_100.amount to 0, Coin.COIN_50.amount to 0, Coin.COIN_10.amount to 0)
        while (remaining > 0 && initialAmount > 0) {
            val remainder = remaining / Coin.COIN_100.amount
            var coins = 0
            if(initialCoinMap.getValue((Coin.COIN_100.amount)) >= remainder) {
                remaining -= remainder*100
                coins = remainder
            } else {
                remaining -= initialCoinMap.getValue((Coin.COIN_100.amount)) * 100
                coins = initialCoinMap.getValue((Coin.COIN_100.amount))
            }
            changeCoinMap[100] = coins
        }
        return changeCoinMap
    }
}