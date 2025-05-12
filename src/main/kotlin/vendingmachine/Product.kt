package vendingmachine

class Product(
    val name: String,
    val price: Int,
    val quantity: Int,
) {
    fun isProductAvailable(): Boolean {
        return quantity > 0
    }
}