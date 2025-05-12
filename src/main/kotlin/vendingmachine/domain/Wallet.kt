package vendingmachine.domain

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin

class Wallet(private var balance: Int) {

    fun hasEnough(amount: Int): Boolean = balance >= amount

    fun deduct(amount: Int) {
        require(hasEnough(amount)) {"[ERROR] Not enough balance"}
        balance-= amount
    }

    fun currentBalance(): Int = balance

    fun returnChange(): Pair <Map<Coin, Int>, Int>{
        val changeMap = mutableMapOf<Coin, Int>()
        var remaining = balance
        val coinList = Coin.valuesDescending()

        while (remaining >= 10) {
            val coin = Randoms.pickNumberInList(coinList.map { it. amount })
            val selected = Coin.fromAmount(coin) ?: continue
            if (remaining >= selected.amount) {
            changeMap[selected] = changeMap.getOrDefault(selected, 0) + 1
                remaining -= selected.amount
            }
        }
        val unreturnable = remaining
        balance = 0
        return changeMap to unreturnable
    }
}