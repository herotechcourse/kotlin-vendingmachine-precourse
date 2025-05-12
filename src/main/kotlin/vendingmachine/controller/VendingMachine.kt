package vendingmachine.controller

import vendingmachine.view.InputView

class VendingMachine {
    val inputView = InputView()

    fun run() {
        val balance = inputView.inputMachineBalance()
    }
}