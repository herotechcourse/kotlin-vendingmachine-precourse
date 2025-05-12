package vendingmachine.domain

class Product (
    val name: String,
    val price: Int,
    private var quantity: Int
    ) {
        init {
            require(name.isNotBlank()) {"[ERROR] Product name can't be empty"}
            require(price >= 100) {"[ERROR] Product price must be at least 100 KRW"}
            require(quantity >= 1) {"[ERROR] Product quantity must be at least 1" }
        }
    fun isSameName(input: String): Boolean =
        name.equals(input.trim(), ignoreCase = true)

    fun isSoldOut(): Boolean = quantity ==0

    fun isPurchasableWith(balance: Int): Boolean =
        price <= balance && !isSoldOut()

    fun purchase() {
        require(!isSoldOut()) {"[ERROR] Product is sold out"}
        quantity--
    }
    fun currentQuantity(): Int = quantity
}