package vendingmachine

class PurchaseResult(
    val success: Boolean,
    val drink: Drink?,
    val message: String? = null
)

