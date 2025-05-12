package vendingmachine

class Product(val name: String, val price: Int) {
    init {
        require(price > 0 && price % 10 == 0) { "[ERROR] Product price must be divisible by 10" }
    }
}