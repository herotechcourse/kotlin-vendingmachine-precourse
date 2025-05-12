package vendingmachine.controller

import vendingmachine.model.CoinsGenerator
import vendingmachine.model.Product
import vendingmachine.view.InputView

class VendingMachine {
    val inputView = InputView()

    fun run() {
        val balance = inputView.inputMachineBalance()

        val coinsGenerator = CoinsGenerator(balance)
        val machineBalance = coinsGenerator.createCoins()
        //println(machineBalance.map { "${it.key}: ${it.value}" }.joinToString(", "))
        val products = inputView.inputProduct()
        println(products[0].name + " "+ products[0].price +" " + products[0].quantity )
    }
}