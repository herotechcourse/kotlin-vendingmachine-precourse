package vendingmachine

import vendingmachine.utils.InputView
import vendingmachine.utils.OutputView

fun main() {

    val machineAmountHold = InputView.readVendorMachineMoney()

    val machineCoinsHold = VendorMachineCoinsFactory.generateRandomCoins(machineAmountHold)
    OutputView.displayCoins(machineCoinsHold)

    val products = InputView.readProductNamePriceQuantity()

    products.forEach { println(it.toString()) }


}
