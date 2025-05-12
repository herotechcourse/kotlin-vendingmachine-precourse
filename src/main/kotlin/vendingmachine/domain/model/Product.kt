package vendingmachine.model

class Product(
    private val name: String,
    private val cost: Int,
    private var quantities: Int,
) {
    fun getName(): String = name
    
    fun getCost(): Int = cost

    fun getQuantities(): Int = quantities

    fun setQuantities(newQuantities: Int) {
        quantities = newQuantities
    }
}
