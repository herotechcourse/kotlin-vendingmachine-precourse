package vendingmachine

import vendingmachine.controller.VendingMachineControllerImpl

fun main() {
    val vendingMachineController = VendingMachineControllerImpl()
    vendingMachineController.run()
}
