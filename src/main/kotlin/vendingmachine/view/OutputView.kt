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

    fun displayChangeReturned(returned: Pair<Int, List<Coin>>) {
        println(Constants.CHANGE_RETURNED)
        val fiveH = returned.second.count { it.amount == 500 }
        val oneH = returned.second.count { it.amount == 100 }
        val fifty = returned.second.count { it.amount == 50 }
        val ten = returned.second.count { it.amount == 10 }
        if (fiveH > 0) println("500 KRW - $fiveH")
        if (oneH > 0) println("100 KRW - $oneH")
        if (fifty > 0) println("50 KRW - $fifty")
        if (ten > 0) println("10 KRW - $ten")
        if (returned.first > 0) println("${Constants.UNABLE_TO_RETURN} ${returned.first} KRW")
    }

    object Constants {
        const val VENDING_COINS = "Coins in the vending machine:"
        const val CHANGE_RETURNED = "Change returned:"
        const val UNABLE_TO_RETURN = "Unable to return:"
    }
}