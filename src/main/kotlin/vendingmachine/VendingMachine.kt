package vendingmachine


class VendingMachine(val exchangedCoins: List<ExchangedCoin>, val products: List<Product>) {
	fun run(amount: Int) {
		var current = amount
		while (true) {
			printInsertedAmount(current)
			if (!products.isPurchasePossible(current))
				break
			val targetName = InputView.readProductPurchase(products)
			val targetProduct = products.filter { it.name == targetName }
		}
	}

	private fun calculate() {

	}

}