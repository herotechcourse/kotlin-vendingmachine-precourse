package vendingmachine.view

import vendingmachine.Coin

class OutputView {

    fun displayInt(input: Int) {
        println("Entered Amount: ${input}")
    }

    fun displayCoinChanges(coins: MutableList<Coin>){
        println("Coins in the vending machine:")
        
        println("500 KRW - ${coins.count { it == Coin.COIN_500 }}")
        println("100 KRW - ${coins.count { it == Coin.COIN_100 }}")
        println("50 KRW - ${coins.count { it == Coin.COIN_50 }}")
        println("10 KRW - ${coins.count { it == Coin.COIN_10 }}")
    }

}
