package vendingmachine.views

import vendingmachine.Coin
import vendingmachine.CoinGenerator
import vendingmachine.CoinTable

object OutputView {
    fun printVendingMachineAmount(purchaseAmount: Int) {
        println("Inserted amount: $purchaseAmount ")
    }

    fun printInitialCoins(amount: CoinTable){
        println("Coins in the vending machine:")

        val counts = amount.getCoinCount()

        println("500 KRW – ${counts.getOrDefault(Coin.COIN_500, 0)}")
    }

}
