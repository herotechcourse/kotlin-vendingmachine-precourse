package vendingmachine

import view.InputView
import view.OutputView

fun main() {
    val amount = InputView.readVendingMachineAmount()
    val coins: Map<Coin, Int> = CoinGenerator.issue(amount)
    OutputView.coinsInMachine(coins)
    val products = InputView.readListOfProduct()
    val balance = Balance(InputView.readAmount(), coins)
    val machine = VendingMachine(balance, products)
    OutputView.insertedAmount(balance.remaining)
//    while (canProceedOrder()) {
//        val orderedProduct = InputView.purchaseProduct()
//
//    }
}

