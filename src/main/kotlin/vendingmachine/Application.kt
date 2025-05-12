package vendingmachine

fun main() {
    val products = mutableListOf<MutableList<String>>()
    // TODO: Implement the program
    val vendorLogic = VendorLogic()
    val outputView = OutputView()
    val inputView = InputView()
    val customerLogic = CustomerLogic()

    outputView.askSellerMachineAmount()
    val machineAmount = inputView.setupAmountOfCoins()
    vendorLogic.generateListOfCoins(machineAmount)

    outputView.askSellerProductName()
    val name = inputView.setupProductName()
    outputView.askSellerProductPrice()
    val price = inputView.setupProductPrice()
    outputView.askSellerProductQuantity()
    val quantity = inputView.setupProductQuantity()

    val productDescription = vendorLogic.generateListOfProducts(name, price, quantity)
    products.add(productDescription)

    outputView.askCostumerAmount()
    val customerAmount = inputView.customerAmount()

    outputView.askCostumerProduct()
    val customerProduct = inputView.customerProduct()

    customerLogic.treatCustomerPurchase(machineAmount, products, customerAmount, customerProduct)


//    vendorLogic.generateListOfProducts("Cola", 1500, 20)
}
