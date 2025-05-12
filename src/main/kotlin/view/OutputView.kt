package view

import vendingmachine.Coin

object OutputView {
    fun coinsInMachine(coins: Map<Coin, Int>) {
        for (coin in coins) {
            println("${coin.key} - ${coin.value}")
        }
    }
}