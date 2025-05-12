package vendingmachine

class Product(private val products: MutableMap<String, List<Int>>) {

    fun productPrice(key: String): Int {
        if (!productExists(key)) {
            return 0
        }

        return products[key]?.get(0) ?: 0
    }

    fun canBuyAnything(amount: Int): Boolean {
        return amount >= products.keys.map { key -> products[key]?.get(0) ?: (amount + 1) }.minOf { it }
    }

    fun productExists(key: String): Boolean {
        products.keys.forEach { it ->
            if (it == key) {
                return true
            }
        }
        return false
    }

    fun decreaseQuantity(key: String) {
        if (!productExists(key)) {
            return
        }

        val price = products[key]?.get(0) ?: 0
        val quantity = products[key]?.get(1) ?: 0

        products[key] = listOf(price, quantity - 1)
    }

    fun showProducts() {
        println(products.entries)
    }
}