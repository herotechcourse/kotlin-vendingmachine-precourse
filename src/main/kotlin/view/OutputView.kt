package view

import vendingmachine.Coin

object OutputView {
    fun coinsInMachine(coins: Map<Coin, Int>) {
        for (coin in coins) {
            println("${coin.key} - ${coin.value}")
        }
    }

    fun insertedAmount(amount: Int) {
        println("Inserted amount: ${amount} KWR")
    }
}