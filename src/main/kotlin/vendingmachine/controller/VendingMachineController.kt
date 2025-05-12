package vendingmachine.controller

import vendingmachine.InputValidator
import vendingmachine.presentation.InputView
import vendingmachine.presentation.OutputView
import java.lang.IllegalArgumentException

interface VendingMachineController {
    fun run()
}

class VendingMachineControllerImpl(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val inputValidator: InputValidator,
) : VendingMachineController {

    private fun processInitialAmount(): Int {
        outputView.printInputPrompt(INITIAL_AMOUNT_MESSAGE)
        val input = inputView.readInitialAmount()
        return try{
            inputValidator.validateInitialAmount(input)
        }catch (e: IllegalArgumentException){
            outputView.printErrorMessage(e.message)
            processInitialAmount()
        }
    }

    override fun run() {
    }

    companion object {
        private const val INITIAL_AMOUNT_MESSAGE = "Enter the amount the vending machine holds:"
    }
}