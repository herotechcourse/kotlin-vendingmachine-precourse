package vendingmachine

data class Drink(val name: String, val price: Int, var stock: Int) {
    fun isAvailable (): Boolean = stock > 0
    fun purchase() {
        if(stock<=0) throw IllegalArgumentException("Out of stock")
        stock-=1
    }
}