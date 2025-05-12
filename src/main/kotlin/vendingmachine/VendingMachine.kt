package vendingmachine


class VendingMachine(val exchangedCoins: List<ExchangedCoin>, val products: List<Product>, val amount: Int) {
	fun run() {
		val current = running()
		val newList = updatePurchase(exchangedCoins, current)
		OutputView.displayResults(newList)
	}

	fun updatePurchase(vendingMachineHas: List<ExchangedCoin>, changeReturn: Int): List<ExchangedCoin> {

		val removal = Coin.exchange(changeReturn)
		val newList = mutableListOf<ExchangedCoin>()

		for (i in 0 until removal.size) {
			val found = vendingMachineHas.firstOrNull() { it.coin == removal[i].coin}
			if (found == null)
				continue
			if (found.count > removal[i].count)
				newList.add(ExchangedCoin(found.coin, found.count, 0))
		}
		return newList
	}

	private fun running() : Int {
		var current = amount
		while (true) {
			InputView.printInsertedAmount(current)
			if (!products.isPurchasePossible(current))
				break
			val targetName = InputView.readProductPurchase(products)
			val targetProduct = products.first { it.name == targetName }
			current = current - targetProduct.price
			targetProduct.purchase()
		}
	return current
	}
}