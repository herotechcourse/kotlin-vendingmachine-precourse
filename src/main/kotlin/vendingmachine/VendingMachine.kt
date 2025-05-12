package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class VendingMachine() {
    val coinsMap = mutableMapOf<Coin, Int>()
    val coinsChange = mutableMapOf<Coin, Int>()
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

    fun generateChange() {
        Coin.entries.filter { it != Coin.NONE }.forEach { coin ->
            var count = coinsMap.getOrDefault(coin, 0)
            while (count > 0 && coin.amount <= userBalance) {
                userBalance -= coin.amount
                count -= 1
                coinsChange[coin] = coinsChange.getOrDefault(coin, 0) + 1
            }
        }
    }

    private fun record(coin: Coin) {
        coinsMap[coin] = coinsMap.getOrDefault(coin, 0) + 1
    }
}