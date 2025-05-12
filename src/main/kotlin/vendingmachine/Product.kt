package vendingmachine

class Product (private val name: String, private val price : Int, private val quantity : Int) {

    private fun validatePrice()
    private fun validateQuantity()
    private fun validatePurchase()
    private fun checkAvailability()
}