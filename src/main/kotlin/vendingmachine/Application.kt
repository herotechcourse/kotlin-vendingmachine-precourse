package vendingmachine

fun main() {
    val initialAmount = InputView.initialAmountInput()
    val vendingMachine = VendingMachine()
    val coins = vendingMachine.initialCoinsInMachine(initialAmount)
    println("\nCoins in the vending machine:")
    OutputView.printCoinsInMachine(coins)
    val products = InputView.productDetailsInput()
    val purchaseAmount = InputView.productPurchaseAmountInput()
    var remainingAmount = purchaseAmount
    repeat(products.size) {
        val productName = InputView.productPurchaseName(remainingAmount)
        var index = 0
        for(product in products) {
            if (product.name == productName) {
                index = products.indexOf(product)
            }
        }
        remainingAmount -= products[index].price
    }
    println("\nInserted amount: $remainingAmount KRW")
    OutputView.printCoinsInMachine(vendingMachine.changeReturned(initialAmount,remainingAmount,coins))
}
