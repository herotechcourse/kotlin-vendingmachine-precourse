package vendingmachine.controller

import vendingmachine.view.InputView
import vendingmachine.view.OutputView
import vendingmachine.VendingMachine
import vendingmachine.domain.CoinBalanceGenerator
import vendingmachine.domain.CoinBalance

class VendingMachineController (
    private val inputView: InputView,
    private val outputView: OutputView
){
    fun run() {
        val vendingMachine = createVendingMachine()
        val balance = CoinBalance(vendingMachine.balanceCoinSum).balance
        val generatorSecond = CoinBalanceGenerator(vendingMachine.balanceCoinSum, balance)

        generatorSecond.generateCoinBalance()
        outputView.displayBalanceCoin(balance)
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