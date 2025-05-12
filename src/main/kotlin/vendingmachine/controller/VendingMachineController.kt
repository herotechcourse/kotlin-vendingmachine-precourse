package vendingmachine.controller

import vendingmachine.view.InputView
import vendingmachine.view.OutputView
import vendingmachine.VendingMachine

class VendingMachineController (
    private val inputView: InputView,
    private val outputView: OutputView
){
    fun run() {
        createVendingMachine()
    }

    private fun createVendingMachine(): VendingMachine{
        while (true) {
            val input = inputView.getCoinBalance()
            try {
                return VendingMachine(input)
            } catch (e: IllegalArgumentException) {
                outputView.displayError(e.message)
            }
        }

    }

}