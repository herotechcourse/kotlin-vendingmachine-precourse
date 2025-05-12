package vendingmachine.service

import vendingmachine.view.InputView
import vendingmachine.view.OutputView

import vendingmachine.domain.machineProducts

object VendingMachineSetting {
    fun run() {
        val amount = InputView.readCoinAmount()
        val machine = VendingMachine(amount)
        OutputView.coinsVendingMachine(machine.getCoinInventory())

        val productInputs = InputView.readProducts()
        val products = machineProducts.generateProducts(productInputs)
        machine.addProducts(products)

        val insertedAmount = InputView.readAmountOfMoneyInserted()
        machine.setUserBalance(insertedAmount)
        OutputView.currentlyAmount(insertedAmount)

        while (true) {
            val cheapest = products.filter { it.quantity > 0 }.minByOrNull { it.price }?.price ?: break
            if (machine.getBalance() < cheapest) break

            val selected = InputView.buyProduct()
            val success = machine.purchaseProduct(selected)
            if (!success) {
                println("[ERROR] Invalid purchase or insufficient funds.")
            } else {
                OutputView.currentlyAmount(machine.getBalance())
            }
        }

        val (change, unreturned) = machine.returnChange()
        OutputView.displayChange(change)
        if (unreturned > 0) {
            println("\nUnable to return: $unreturned KRW")
        }
    }
}
