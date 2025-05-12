package vendingmachine.view

import vendingmachine.domain.Coin

object OutputView {

    fun coinsVendingMachine(resultMap: Map<Coin, Int>) {

        println("\nCoins in the vending machine:")
        val displayOrder = listOf(
            Coin.COIN_500,
            Coin.COIN_100,
            Coin.COIN_50,
            Coin.COIN_10
        )

        for (coin in displayOrder) {
            val count = resultMap[coin] ?: 0
            println("${coin.amount} KRW – $count")
        }

    }

    fun currentlyAmount(amount: Int) {
        println("\nInserted amount: $amount")
    }

    fun changeReturned(amount: Int) {
        println("\nChange returned:")

    }
}