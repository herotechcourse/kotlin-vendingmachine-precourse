package vendingmachine.controller

import vendingmachine.presentation.InputView
import vendingmachine.presentation.OutputView

interface VendingMachineController {
    fun run()
}

class VendingMachineControllerImpl(
    private val inputView: InputView,
    private val outputView: OutputView,
) : VendingMachineController {

    private fun processInitialAmount(): Int {
        outputView.printInputPrompt(INITIAL_AMOUNT_MESSAGE)
        val input = inputView.readInitialAmount().toInt()
        return input
    }

    override fun run() {
    }

    companion object {
        private const val INITIAL_AMOUNT_MESSAGE = "Enter the amount the vending machine holds:"
    }
}