package vendingmachine

const val MIN_PRICE_AMOUNT = 100

class Product(val name: String, private val price: Int, val quantity: Int) {
    init {
        require(price > MIN_PRICE_AMOUNT) { "[ERROR] Minimum price is 100." }
        require(price % 10 == 0) { "[ERROR] The price must be divisible by 10." }
    }
}