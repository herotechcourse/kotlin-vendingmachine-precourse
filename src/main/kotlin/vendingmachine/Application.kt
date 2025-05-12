package vendingmachine

fun main() {
    // TODO: Implement the program
val prouctDetail= ProuctDetail()
    prouctDetail.getProductName()

    val initialAmount = InputView.initialAmountInput()

// println(initialAmount)
// val vendingMachine = VendingMachine()
// val coins = vendingMachine.initialCoinsInMachine(initialAmount)    println(coins.entries)//
// InputView.productDetailsInput()//
// println(InputView.productPurchaseAmountInput())//
// println(InputView.productPurchaseName(initialAmount))

  val balanceAmount = BalanceAmount()
    balanceAmount.readBalanceAmount()

    val vendingMachine = VendingMachine(changeInventory)
    vendingMachine.getRandomCoins()




}

