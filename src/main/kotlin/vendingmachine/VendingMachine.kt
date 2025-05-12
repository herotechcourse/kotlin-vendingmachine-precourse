package vendingmachine

class VendingMachine (private val initAMount: Int) {
    private val inventory = mutableMapOf<Product, Int>()
    private var cheapestProduct : Int = 0
    private var userBudget : Int = 0

    fun runMachine() {
        OutputView.displayCoins(initAMount)
        InputView.handleInventory() //returns a list of products, maybe generate map later
        cheapestProduct = inventory.minOf{it.value}
        userBudget = InputView.handleUserBudget()
        while (userBudget >= cheapestProduct) //incorrect, it needs to be bigger than the value of the cheapest product
        {
            val product = InputView.handlePurchaseOfProduct(inventory) //still not returning anything
        }
    }
}