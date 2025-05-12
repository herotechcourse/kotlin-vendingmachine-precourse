package vendingmachine

import vendingmachine.view.InputView
import vendingmachine.view.OutputView
import vendingmachine.VendingMachine
import vendingmachine.controller.VendingMachineController

fun main() {

    val inputView = InputView()
    val outputView = OutputView()
    val vendingMachineController = VendingMachineController(inputView, outputView)

    vendingMachineController.run()

}
