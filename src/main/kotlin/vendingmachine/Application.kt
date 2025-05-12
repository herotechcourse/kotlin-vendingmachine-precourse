package vendingmachine

fun main() {
    val inputView = InputView()
    val vendingMachine = VendingMachine()

    while (true) {
        try {
            val inputMachineHolds = inputView.validateAmountMachineHolds(inputView.readAmountMachineHolds())
            vendingMachine.initializeCoinInventory(inputMachineHolds)
            //OutputView.printCoins(vendingMachine.availableCoins, "Coins in the vending machine:")
            OutputView.primaryCoinPrint(vendingMachine.availableCoins)
            val availableProducts = inputView.processProductsList(inputView.readProductList())
            vendingMachine.initializeProductInventory(availableProducts)
            val userMoney = inputView.validateUserMoney(inputView.readUserMoneyAmount())
            vendingMachine.initializeUserMoney(userMoney)
            break
        } catch (e: IllegalArgumentException) {
            println("${e.message}\nTry again\n" )
        }
    }
    while (true) {
        OutputView.printAmount(vendingMachine.userMoneyAmount, "Inserted amount")
        try {
            vendingMachine.purchaseProcessor(inputView.purchaseReader())
            if (vendingMachine.checkEndingConditions()) {
                break
            }
        } catch (e: IllegalArgumentException) {
            println("${e.message}\nTry again\n" )
        }

    }

}
