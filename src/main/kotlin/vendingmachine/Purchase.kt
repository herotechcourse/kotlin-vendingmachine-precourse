package vendingmachine

class Purchase(private val products: Product, private val vendingMachine: VendingMachine) {
    fun startPurchase() {
        while (products.canBuyAnything(vendingMachine.userBalance)) {
            try {
                handlePurchase()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        OutputView.printInsertedAmount(vendingMachine.userBalance)
    }

    private fun handlePurchase() {
        OutputView.printInsertedAmount(vendingMachine.userBalance)
        val key = InputView.readValidProductName()
        checkProductExists(key)
        handleProductPurchase(key)
    }

    private fun checkProductExists(key: String) {
        if (!products.productExists(key)) throw IllegalArgumentException("[ERROR] Product does not exists")
    }

    private fun handleProductPurchase(key: String) {
        val price = products.productPrice(key)
        vendingMachine.reduceUserBalance(price)
        products.decreaseQuantity(key)
    }
}