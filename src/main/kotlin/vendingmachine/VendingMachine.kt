package vendingmachine

class VendingMachine(val balance: Balance, private val products: List<String>) {
    val store: Map<Product, Int> = mutableMapOf<Product, Int>().withDefault { 0 }

    init {
        products.onEach {
            val list = it.split(",")
                        .onEach { require(it.isNotEmpty()) { "[ERROR] Product is empty" } }
                        .map { it.trim() }
            val product = Product(list[0], list[1].toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Price must be numeric"))
            val quantity = list[2].toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Price must be numeric")
            require(quantity > 0) { "[ERROR] Quantity must be positive number" }
            store.plus(Pair(product, store.getOrDefault(product, 0) + quantity))
        }
    }

    fun canProceedOrder(): Boolean {

        val cheapest = store.keys.filter {  }
    }

    private fun minPrice(): Int {
        var min = 0
    }
}