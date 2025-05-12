package vendingmachine

fun main() {
    // TODO: Implement the program
    val inputView = InputView()
    val validator = Validator()

    val coinAmount = readAndValidateCoinAmount(inputView, validator)
    println(coinAmount)

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
