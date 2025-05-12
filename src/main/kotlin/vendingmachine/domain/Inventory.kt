package vendingmachine.domain

class Inventory(private val products: List<Product>) {

    fun findByName(name: String): Product? =
        products.firstOrNull {it.isSameName(name)}

    fun isPurchasable(name: String, balance: Int): Boolean {
        val product = findByName(name) ?: return false
        return product.isPurchasableWith(balance)
    }

    fun purchase(name: String): Int {
        val product = findByName(name)
            ?: throw IllegalArgumentException("[ERROR] Product not found: $name")
        product.purchase()
        return product.price
    }

    fun availableProducts(): List<Product> =
        products.filter {!it.isSoldOut()}

    companion object {
        fun from(raw: String): Inventory {
            val parsed = raw.split(";").map { part ->
                val trimmed = part.trim().removeSurrounding("[", "]")
                val tokens = trimmed.split(",").map {it.trim()}
                if(tokens.size != 3){
                    throw IllegalArgumentException("[ERROR] Invalid product format")
                }

                val (name, priceStr, quantityStr) = tokens
                val price = priceStr.toIntOrNull()
                val quantity = quantityStr.toIntOrNull()

                if (price == null || quantity == null) {
                    throw IllegalArgumentException("[ERROR] Invalid price or quantity")
                }
                Product(name, price, quantity)
            }
            return Inventory(parsed)
        }
    }
}