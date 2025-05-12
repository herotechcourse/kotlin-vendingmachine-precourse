package vendingmachine.domain

data class Product(val name: String, val price: Int, var quantity: Int) {
    companion object {
        fun create(name: String, price: Int, quantity: Int): Product {
            require(name.isNotBlank()) { "[ERROR] Product name must not be blank." }
            require(price >= 100 && price % 10 == 0) { "[ERROR] Product price must be >=100 and divisible by 10." }
            require(quantity > 0) { "[ERROR] Quantity must be greater than 0." }
            return Product(name, price, quantity)
        }
    }
}