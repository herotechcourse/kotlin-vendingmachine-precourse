package vendingmachine

fun main() {
    // take amount of money for machine to hold
    val amountMachineHold = retryable{
        InputView.readMoneyAmount("Enter the amount the vending machine holds:")
    }

    // initialize machine with taken amount
    val machine = Machine(amountMachineHold)

    // display generated holding coins in machine
    OutputView.showHoldingCoins(machine)

    // take product info, including name, price, qt
    val products = retryable{ InputView.readProductInfo() }
    machine.setProducts(products)

    // take amount of money for user to use
    val amountUserPut = retryable{
        InputView.readMoneyAmount("\nPlease enter the amount of money:")
    }
    machine.setRemaining(amountUserPut)

    // display remaining amount of money for user
    println(machine.getRemainingInfo())

    // get least price among products
    val prices =  products.map { it.price }
    val minPrice = prices.min()


    // LOOP
    while (machine.remaining > minPrice || machine.isAnyAvailable()) {
        // take name of product to purchase
        val purchasingProduct = retryable{ InputView.readPurchasingProduct(products) }

        // process order
        machine.processOrder(purchasingProduct)

        // display remaining amount of money for user
        println(machine.getRemainingInfo())
    }
    // if must return, lack of remained amount of money
    // display change to be returned
        // if unable to return full amount
        // display the amount of change to be returned but unable
}

private fun <T> retryable(inputMethod: () -> T): T {
    while (true) {
        try {
            return inputMethod()
        } catch (err: IllegalArgumentException) {
            println("${err.message}")
        }
    }
}