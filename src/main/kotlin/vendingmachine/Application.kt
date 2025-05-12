package vendingmachine

fun main() {
    val vendingMachine = VendingMachine()

    val vendingMachineAmount = InputView.readValidVendingMachineAmount()

    vendingMachine.generateCoins(vendingMachineAmount)
    OutputView.printGeneratedCoins(vendingMachine.coinsMap)

    val products = Product(InputView.readValidProducts())

    vendingMachine.setBalance(InputView.readValidPurchaseAmount())

    val purchase = Purchase(products, vendingMachine)
    purchase.startPurchase()

    vendingMachine.generateChange()

    OutputView.printChangeCoins(vendingMachine.coinsChange)
    OutputView.printUnableToReturn(vendingMachine.userBalance)
}
