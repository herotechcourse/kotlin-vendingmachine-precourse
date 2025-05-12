package vendingmachine.view

import vendingmachine.domain.Coin

object OutputView {
    fun coinsVendingMachine(coinMap: Map<Coin, Int>) {
        println("\nCoins in the vending machine:")
        Coin.valuesDescending.forEach { coin ->
            val count = coinMap[coin] ?: 0
            println("${coin.amount} KRW - $count")
        }
    }

    fun currentlyAmount(amount: Int) {
        println("\nInserted amount: $amount KRW")
    }

    fun displayChange(changeMap: Map<Coin, Int>) {
        println("\nChange returned:")
        changeMap.forEach { (coin, count) ->
            println("${coin.amount} KRW - $count")
        }
    }
}