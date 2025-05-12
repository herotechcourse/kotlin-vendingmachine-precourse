package vendingmachine

fun main() {
    val initialAmount = InputView.initialAmountInput()
    val vendingMachine = VendingMachine()
    val coins = vendingMachine.initialCoinsInMachine(initialAmount)
    println(coins.entries)
//    InputView.productDetailsInput()
//    println(InputView.productPurchaseAmountInput())
//    println(InputView.productPurchaseName(initialAmount))
}
