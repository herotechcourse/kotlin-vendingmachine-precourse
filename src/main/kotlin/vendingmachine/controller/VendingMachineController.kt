package vendingmachine.controller

import vendingmachine.view.InputView
import vendingmachine.view.OutputView
import vendingmachine.VendingMachine
import vendingmachine.domain.CoinBalanceGenerator

class VendingMachineController (
    private val inputView: InputView,
    private val outputView: OutputView
){
    fun run() {
        val vendingMachine = createVendingMachine()
        val generator = CoinBalanceGenerator().balance
        outputView.displayBalanceCoin(generator)

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