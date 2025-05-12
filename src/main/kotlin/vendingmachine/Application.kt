package vendingmachine

import vendingmachine.core.VendorMachine
import vendingmachine.utils.InputView
import vendingmachine.utils.OutputView

fun main() {

    val machineAmountHold = InputView.readVendorMachineMoney()

    val machineCoinsHold = VendorMachineCoinsFactory.generateRandomCoins(machineAmountHold)
    OutputView.displayCoins(machineCoinsHold)

    val products = InputView.readProductNamePriceQuantity()

    products.forEach { println(it.toString()) }



    val vendorMachine = VendorMachine(
        machineAmountHold,
        machineCoinsHold,
        products
    )

    val userMoneyAmount = InputView.readUserAmountOfMoney()


    vendorMachine.handlePurchases(userMoneyAmount)






}
