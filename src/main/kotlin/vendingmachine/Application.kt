package vendingmachine

import vendingmachine.views.InputView
import vendingmachine.views.OutputView

fun main() {
    val MachineAmount = InputView.readVendingMachineAmount()
    val initialTable = CoinTable.generateTable(MachineAmount)
    OutputView.printInitialCoins(initialTable)

    val products = InputView.readProducts()
    val purchaseAmount = InputView.readPurchaseAmount()
    OutputView.printVendingMachineamount(purchaseAmount)

    while (purchaseAmount >= cheapestproduct) {
        val purchaseProduct = InputView.readPurchaseProduct()
        OutputView.printNewPurchase(purchaseAmount)
    }








}
