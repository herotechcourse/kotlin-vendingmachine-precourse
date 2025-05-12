package vendingmachine

import vendingmachine.service.CoinsGeneratorService
import vendingmachine.service.ProductsGeneratorService
import vendingmachine.view.InputView
import vendingmachine.view.OutputView
import vendingmachine.model.VendingMachine
import vendingmachine.exception.VendingMachineException

inline fun <T> retry(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: VendingMachineException) {
            println(e.message)
        }
    }
}

fun main() {
    val amount = retry(InputView::readVendingMachineAmount)
    val coins = CoinsGeneratorService.generateWith(amount)
    OutputView.displayVendingMachineCoins(coins)
    val products = retry({ ProductsGeneratorService.generateWith(InputView.readProducts()) })
    val vMachine = VendingMachine(coins, products)
    var clientAmount = retry({ vMachine.validateUserAmount(InputView.readClientAmount()) })
    vMachine.addClientAmount(clientAmount.first)
    if (!clientAmount.second) {
        OutputView.displayChangeReturned(vMachine.returnChange())
        return
    }
    while (true) {
        val product = retry( {vMachine.validateProduct(InputView.readClientProduct(clientAmount.first))})
        vMachine.purchaseProduct(product)
        clientAmount = vMachine.validateUserAmount(vMachine.clientAmount)
    }
}
