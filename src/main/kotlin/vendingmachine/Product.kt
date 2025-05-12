package vendingmachine

class Product(
    val name: String,
    val price: Int,
    private var quantity: Int,
) {

    fun getQuantity(): Int {
        return quantity
    }

    fun isProductAvailable(): Boolean {
        return quantity > 0
    }

    fun reduceQuantityOne() {
        quantity--
    }

}


