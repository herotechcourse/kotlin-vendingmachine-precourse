package vendingmachine

import vendingmachine.service.CoinsGeneratorService
import vendingmachine.view.InputView
import vendingmachine.model.VendingMachine

fun main() {
    val amount = InputView.readVendingMachineAmount()
    val coins = CoinsGeneratorService.generateWith(amount)
    val vMachine = VendingMachine(coins)
}
