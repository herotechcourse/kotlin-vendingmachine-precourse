package vendingmachine

class ProductInventory {
	val inventory: HashMap<String, Product> = hashMapOf()

	fun registerProduct(product: Product) {
		inventory[product.name] = product
	}

	fun sellItems(productName: String, amount: Int = 1): Int {
		val product = inventory[productName]!!
		return product.sellItems(amount)
	}
}