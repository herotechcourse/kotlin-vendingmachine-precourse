package vendingmachine


class VendingMachine(val exchangedCoins: List<ExchangedCoin>, val products: List<Product>, val amount: Int) {
	fun run() {
		var current = amount
			while (true) {
				InputView.printInsertedAmount(current)
				if (!products.isPurchasePossible(current))
					break
				val targetName = InputView.readProductPurchase(products)
				val targetProduct = products.first { it.name == targetName }
				current - targetProduct.price
				targetProduct.purchase()
		}
		val newList = updatePurchase(exchangedCoins, current)
		OutputView.displayResults(newList)
	}

	fun updatePurchase(vendingMachineHas: List<ExchangedCoin>, changeReturn: Int): List<ExchangedCoin> {

		val removal = Coin.exchange(changeReturn)
		val newList = mutableListOf<ExchangedCoin>()
		for (i in 0 .. removal.size) {
			val found = vendingMachineHas.first { it.coin == removal[i].coin}
			if (found.count > removal[i].count)
				newList.add(ExchangedCoin(found.coin, found.count, 0))
		}
		return newList
	}


}