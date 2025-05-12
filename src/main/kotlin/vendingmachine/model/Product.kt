package vendingmachine.model

class Product(val name: String, val price: Int, var quantity: Int) {

    fun isSoldOut(): Boolean {
        return this.quantity == 0
    }
}