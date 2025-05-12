package vendingmachine

import vendingmachine.domain.Wallet
import vendingmachine.service.VendingMachine
import vendingmachine.view.InputView
import vendingmachine.view.OutputView

fun main() {
    val machine = VendingMachine(mutableMapOf())

    val machineAmount = InputView.readMachineCoinAmount()
    machine.generateCoins(machineAmount)

    OutputView.printMachineCoins(machine.getCoinStock())

    val productInput = InputView.readProductInput()
    machine.setProduct(productInput)

    val inserted = InputView.readInsertedAmount()
    val wallet = Wallet(inserted)

    OutputView.printInsertedAmount(wallet.currentBalance())

    machine.startSession(wallet)

    val (changeMap, unreturnable) = machine.returnChange(wallet)
    OutputView.printChange(changeMap, unreturnable)
}
