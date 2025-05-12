package vendingmachine.controller

import vendingmachine.view.InputView
import vendingmachine.view.OutputView
import vendingmachine.Coin

import camp.nextstep.edu.missionutils.Randoms

class VendingMachineController {
    fun run() {
        val change = getInitialChange()
        val coinsInVendingMachine = getChangeCoins(change)

        OutputView().displayCoinChanges(coinsInVendingMachine)
    }

    fun getInitialChange(): Int {
        val change = InputView.enterInitialChange()
        return change
    }

    fun getChangeCoins(change: Int): MutableList<Coin>{
        val coins = mutableListOf<Coin>()
        var remaining = change

        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount
                coins.add(Coin.from(amount))
            }
        }
        return coins
    }
}