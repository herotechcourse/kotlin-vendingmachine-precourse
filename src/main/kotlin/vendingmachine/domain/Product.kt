package vendingmachine.domain

class Product ( feature: List<String> ) {
    private val name = feature[0]
    private val price = feature[1]
    private val quantity = feature[2]

    fun getName() = name
    fun getPrice() = price.toInt()
    fun getQuantity() = quantity

    fun purchaseProduct() {
        quantity.toInt() - 1
    }
}