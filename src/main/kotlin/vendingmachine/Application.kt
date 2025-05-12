package vendingmachine

fun main() {
    val outputView = OutputView()
    val inputView = InputView(outputView)
    val validator = InputValidator()
    val coinsGen = Coins()


    val coinsAmount = inputView.machineCoins()
    val coinsValidator = validator.validateMachineCoins(coinsAmount)

    val generation = coinsGen.generate(coinsAmount)
    outputView.coinsAmount(generation)

    val product = inputView.product()
    val client = inputView.clientMoney()

    outputView.remainingClientMoney()

    val purchase = inputView.productPurchase()

}