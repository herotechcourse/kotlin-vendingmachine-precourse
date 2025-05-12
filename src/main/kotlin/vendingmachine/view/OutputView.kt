package vendingmachine.view

import vendingmachine.Coin.*

class OutputView {

    fun printCoinsAvailable(coinCount: List<Int>){
        println("Coins in the vending machine: ")
        println("${COIN_500.amount} KRW - ${coinCount[0]}")
        println("${COIN_100.amount} KRW - ${coinCount[1]}")
        println("${COIN_50.amount} KRW - ${coinCount[2]}")
        println("${COIN_10.amount} KRW - ${coinCount[3]}")
    }

    fun printInitialMoney(initialMoney: Int) {
        println("Inserted amount: $initialMoney KRW")
    }
}
