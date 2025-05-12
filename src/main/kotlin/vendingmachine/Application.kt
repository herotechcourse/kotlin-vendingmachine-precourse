package vendingmachine

fun main() {
    // TODO: Implement the program
    val vendorLogic = VendorLogic()
    val outputView = OutputView()
    val inputView = InputView()

    outputView.askSellerMachineAmount()
    val machineAmount = inputView.setupAmountOfCoins()
    vendorLogic.generateListOfCoins(machineAmount)

    val product = inputView.setupProduct()
    vendorLogic.generateListOfProducts(product)

//    vendorLogic.generateListOfProducts("Cola", 1500, 20)
}
