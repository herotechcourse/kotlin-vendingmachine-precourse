package vendingmachine

import jdk.jfr.DataAmount

object OutputView {
    fun printCoins(coins: Map<Coin, Int>) {
        println("Coins in the vending machine:")
        Coin.denominationsDescending().forEach {
            println("${it.amount} KRW - ${coins[it] ?:0}")
        }
    }
    fun printInsertedAmount(amount: Int){
        println("Inserted Amount: $amount")
    }

}