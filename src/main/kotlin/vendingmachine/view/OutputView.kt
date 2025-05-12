package vendingmachine.view

import vendingmachine.Coin

object OutputView {

    fun printMachineCoins(coinMap: Map<Coin, Int>){
        println("Coins in the vending machine:")
        Coin.valuesDescending().forEach { coin ->
            val count = coinMap[coin] ?: 0
            println("${coin.amount} KRW - $count")
        }
    }

    fun printInsertedAmount(amount: Int) {
        println("Inserted amount: ${amount} KRW")
    }

    fun printChange(change: Map<Coin, Int>, unreturnable: Int) {
        if (change.isNotEmpty()) {
            println("Change returned:")
            Coin.valuesDescending().forEach {coin ->
                change[coin]?.let { count ->
                    if (count > 0) println("${coin.amount} KRW - $count")
                }
            }
        }
        println("Unable to return: ${unreturnable} KRW")
    }
}