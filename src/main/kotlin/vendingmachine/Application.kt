package vendingmachine

fun main() {
    // TODO: Implement the program
    val inputView = InputView()
    val outputView = OutputView()
    val validator = Validator()
    val coinGenerator = CoinGenerator()

    val coinAmount = readAndValidateCoinAmount(inputView, validator)
    var coinsAvailable = coinGenerator.calculateNumberOfCoins(coinAmount)
    outputView.printCoinsAvailable(coinsAvailable)


}

fun readAndValidateCoinAmount(inputView: InputView, validator: Validator): Int {
    while(true)
        try {
            val coinAmountEntered = inputView.read("Enter the amount the vending machine holds:")
            return validator.isCoinAmountValid(coinAmountEntered)
        }
        catch (e: IllegalArgumentException)
        {
            println("[ERROR] ${e.message}")
        }
}
