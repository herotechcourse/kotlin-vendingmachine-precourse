package vendingmachine

class Product(val productName: String, val productPrice: Int, var productQuantity: Int) {

    init {
        require(productPrice >= 100 && productPrice % 10 == 0) {"[ERROR] Product price should be bigger than 100 and dividble by 10"
        }
    }

    fun sellProduct() {
        if (productQuantity >= 1) {
            productQuantity -= 1
            return
        }

        throw IllegalArgumentException("[ERROR] Product is sold out")
    }
}