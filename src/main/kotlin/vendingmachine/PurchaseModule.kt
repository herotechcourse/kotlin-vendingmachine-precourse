package vendingmachine

import kotlin.math.max

class PurchaseModule(val productInventory: ProductInventory, var coinRepository: CoinRepository, var balance: Int) {

	fun purchasePossible(): Boolean{
		val cheapest = productInventory.inventory.values.minOf {product -> product.price }
		val totalQuantity = productInventory.inventory.values.sumOf {product -> product.quantity }

		return balance >= cheapest && totalQuantity > 0
	}

	fun purchaseItem(productName: String) {
		if (productName !in productInventory.inventory.keys) throw IllegalStateException("[ERROR] Item does not exist")
		val product = productInventory.inventory[productName]!!
		if (product.quantity <= 0) throw  IllegalStateException("[ERROR] Not enough quantity for $productName")
		if (product.price > balance) throw  IllegalStateException("[ERROR] Not enough money for $productName")

		balance -= productInventory.sellItems(productName)
	}

	fun processChange(): HashMap<Int, Int> {
		val changeMap = hashMapOf<Int, Int>(
			500 to 0,
			100 to 0,
			50 to 0,
			10 to 0,
		)
		var currCoin = 500
		while (balance > 0) {
			if (coinRepository.coins[currCoin]!! >= 1) {
				changeMap[currCoin] = min(balance.floorDiv(currCoin), coinRepository.coins[currCoin]!!)
				balance -= changeMap[currCoin]!! * currCoin
			}

			if (currCoin == 500) {
				currCoin = 100
				continue
			}
			if (currCoin == 100) {
				currCoin = 50
				continue
			}
			if (currCoin == 50) {
				currCoin = 10
				continue
			}
			if (currCoin == 10) {
				break
			}
		}
		return changeMap
	}
}