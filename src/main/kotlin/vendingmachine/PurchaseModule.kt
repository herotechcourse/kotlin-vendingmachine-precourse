package vendingmachine

class PurchaseModule(val productInventory: ProductInventory, var coinRepository: CoinRepository, var balance: Int) {

	fun purchasePossible(): Boolean{
		val cheapest = productInventory.inventory.values.minOf {product -> product.price }
		val totalQuantity = productInventory.inventory.values.sumOf {product -> product.quantity }

		return balance >= cheapest && totalQuantity > 0
	}

	fun purchaseItem(productName: String) {
		if (productName in productInventory.inventory.keys) throw  IllegalStateException("[ERROR] Item does not exist")
		val product = productInventory.inventory[productName]!!
		if (product.quantity <= 0) throw  IllegalStateException("[ERROR] Not enough quantity for $productName")
		if (product.price > balance) throw  IllegalStateException("[ERROR] Not enough money for $productName")

		balance -= productInventory.sellItems(productName)
	}

	fun processChange(): HashMap<Int, Int> {
		val changeMap = hashMapOf<Int, Int>(
			10 to 0,
			50 to 0,
			100 to 0,
			500 to 0
		)

		changeMap[500] = balance.floorDiv(500)
		balance -= changeMap[500]!! * 500

		changeMap[100] = balance.floorDiv(100)
		balance -= changeMap[100]!! * 100

		changeMap[50] = balance.floorDiv(50)
		balance -= changeMap[50]!! * 50

		changeMap[10] = balance.floorDiv(10)
		balance -= changeMap[10]!! * 10

		return changeMap
	}
}