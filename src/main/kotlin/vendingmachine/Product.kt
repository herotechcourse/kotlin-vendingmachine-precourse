package vendingmachine

class Product(val name: String, val price: Int, var quantity: Int) {
	fun sellItems(amount: Int): Int {
		if (quantity < amount) throw IllegalStateException("[ERROR] Not enough $name available")
		quantity -= amount
		return price * amount
	}
}