package vendingmachine.utils

import vendingmachine.Coin

object OutputView {

    fun displayCoins (mapOfCoins: Map<Coin, Int>) {
        val listOfCoin = listOf<Coin>(
            Coin.COIN_500, Coin.COIN_100, Coin.COIN_50,
            Coin.COIN_10)

        println()
        listOfCoin.forEach { println("$it KRW - ${mapOfCoins.getOrDefault(it, 0)} ") }

    }
}