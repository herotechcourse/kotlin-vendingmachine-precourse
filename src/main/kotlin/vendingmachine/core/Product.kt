package vendingmachine.core

data class Product(
    val name: String,
    val price: Int,
    var quantity: Int
) {

    fun reduceQuantity() {
        quantity--
    }
}
