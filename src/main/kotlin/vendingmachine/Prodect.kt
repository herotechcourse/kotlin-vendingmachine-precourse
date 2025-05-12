package vendingmachine

data class Product(val name: String, val price: Int, var quantity: Int) {
	fun purchase(): Boolean {
		if (quantity > 0) {
			quantity--
			return true
		}
		return false
	}
}

fun List<Product>.isPurchasePossible(current: Int): Boolean {
	return this.all { it.price < current }

}