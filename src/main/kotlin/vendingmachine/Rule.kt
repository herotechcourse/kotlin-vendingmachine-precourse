package vendingmachine

const val READ_AMOUNT_VENDING_MACHINE = "Enter the amount the vending machine holds:"
const val SHOW_COINS_IN_VENDING_MACHINE = "Coins in the vending machine:"
const val READ_PRODUCTS_GIVEN = "Enter product names, prices, and quantities:"
const val READ_PURCHASE_PRODUCT = "Please enter the name of the product to purchase:"
const val DEFAULT_AMOUNT_TO_INIT = -1
fun printInsertedAmount(amount: Int) {
	println("Inserted amount: $amount KRW")
}