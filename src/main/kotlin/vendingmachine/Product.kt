package vendingmachine

class Product(val productName: String, val price: Int, private var _quantity: Int) {
    val quantity: Int
        get() = _quantity

    init {
        require(productName.isNotEmpty()) { "[ERROR]: empty input" }
        for (char in productName) {
            require(char.isLetter()) { "[ERROR]: product name can only contain letters" }
        }
        require(price >= 100 && price % 10 == 0) { "[ERROR]: invalid price" }
        require(_quantity >= 0) { "[ERROR]: invalid quantity" }
        // TODO maybe add max amount
    }

    fun decreaseQuantity() {
        _quantity--
    }
}