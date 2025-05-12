package vendingmachine.presentation

interface OutputView {

    fun printInputPrompt(promptMessage: String)
    fun printErrorMessage(errorMessage: String)
    fun printMachineCoins()
    fun printCurrentBalance(currentBalance: Int)
    fun printReturnedChange()
    fun printUnreturnedAmount(unreturnedAmount: Int)

}

class OutputViewImpl : OutputView {

    override fun printInputPrompt(promptMessage: String) {
        println(promptMessage)
    }

    override fun printErrorMessage(errorMessage: String) {
        println("$ERROR_MESSAGE_PREFIX $errorMessage")
    }

    override fun printMachineCoins() {
        println()
        println(MACHINE_COIN_MESSAGE)
    }

    override fun printCurrentBalance(currentBalance: Int) {
        println(CURRENT_BALANCE_MESSAGE.format(currentBalance))
    }

    override fun printReturnedChange() {
        println(RETURNED_CHANGED_MESSAGE)
    }

    override fun printUnreturnedAmount(unreturnedAmount: Int) {
        println(UNRETURNED_AMOUNT_MESSAGE.format(unreturnedAmount))
    }

    companion object {
        private const val ERROR_MESSAGE_PREFIX = "[ERROR]"
        private const val MACHINE_COIN_MESSAGE = "Coins in the vending machine:"
        private const val CURRENT_BALANCE_MESSAGE = "Inserted amount: %d KRW"
        private const val RETURNED_CHANGED_MESSAGE = "Change returned:"
        private const val UNRETURNED_AMOUNT_MESSAGE = "Unable to return: %d KRW"
    }

}