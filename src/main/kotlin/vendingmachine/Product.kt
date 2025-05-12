package vendingmachine

class Product(val name: String, val price: Int, val quantity: Int) {
    init{
        require(price % 10 == 0) {"[ERROR] product price should be divisible by 10"}
        require(price >= 100) {"[ERROR] product price should be greater than 100"}
    }

    override fun toString(): String {
        return "Product(name = '$name', price='$price', quantity='$quantity')"
    }
}