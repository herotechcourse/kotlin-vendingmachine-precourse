package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class VendingMachine() {
    val resultMap = mutableMapOf<Coin, Int>()
    var vendingBalance = 0
    var userBalance = 0

    fun setBalance(amount: Int) {
        userBalance = amount
    }

    fun reduceUserBalance(price: Int) {
        userBalance -= price
    }

    fun generateCoins(amount: Int) {
        vendingBalance = amount
        var totalAmount = amount
        while (totalAmount >= 10) {
            val coinValue = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (coinValue > totalAmount) {
                continue
            }
            val coin = Coin.from(coinValue)
            totalAmount -= coinValue
            record(coin)
        }
    }

    fun returnCoins() {}

    private fun record(rank: Coin) {
        resultMap[rank] = resultMap.getOrDefault(rank, 0) + 1
    }
}