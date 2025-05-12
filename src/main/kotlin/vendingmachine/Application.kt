package vendingmachine

import vendingmachine.controller.VendingMachineControllerImpl
import vendingmachine.presentation.InputViewImpl
import vendingmachine.presentation.OutputViewImpl

fun main() {
    val vendingMachineController = VendingMachineControllerImpl(
        inputView = InputViewImpl(),
        outputView = OutputViewImpl(),
        inputValidator = InputValidatorImpl(),
    )
    vendingMachineController.run()
}
