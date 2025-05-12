package vendingmachine.view

import vendingmachine.Coin

object OutputView {
    fun displayVendingMachineCoins(coins: List<Coin>) {
        println(Constants.VENDING_COINS)
        val fiveH = coins.count { it.amount == 500 }
        val oneH = coins.count { it.amount == 100 }
        val fifty = coins.count { it.amount == 50 }
        val ten = coins.count { it.amount == 10 }
        println("500 KRW - $fiveH")
        println("100 KRW - $oneH")
        println("50 KRW - $fifty")
        println("10 KRW - $ten")
    }

    object Constants {
        const val VENDING_COINS = "Coins in the vending machine:"
    }
}