package vendingmachine.controller

import vendingmachine.model.CoinsGenerator
import vendingmachine.view.InputView

class VendingMachine {
    val inputView = InputView()

    fun run() {
        val balance = inputView.inputMachineBalance()

        val coinsGenerator = CoinsGenerator(balance)
        val machineBalance = coinsGenerator.createCoins()
        println(machineBalance.map { "${it.key}: ${it.value}" }.joinToString(", "))
    }
}