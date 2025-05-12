package vendingmachine

import vendingmachine.validators.CombinedValidator
import vendingmachine.validators.CommaSeparatedValidator
import vendingmachine.validators.DivisibleByValidator
import vendingmachine.validators.IntegerValidator
import vendingmachine.validators.NumberRangeValidator
import vendingmachine.validators.NumbersCountValidator
import vendingmachine.validators.NumbersRangeValidator
import vendingmachine.validators.UniqueNumbersValidator

class Application {
    companion object {
        const val COIN_DIVISOR = 10
        const val AMOUNT_PROMPT_TEXT = "Please enter the purchase amount."
    }

    fun main() {
        val inputView = InputView()
        val amount = promptAmount(inputView)
        //println(amount)

        val coin = Coin(amount)
        val coninsInVendingMachine = coin.generate(amount)

        val outputView = OutputView()
        outputView.pintCoinsconinsInVendingMachine



        // hard-coded winning numbers and bonus ball for testing
        println("Coins in the vending machine:")
        println("500 KRW - 0")
        println("100 KRW - 4")
        println("50 KRW -1")
        println("10 KRW - 0")

        println("Enter product names, prices, and quantities:")
        println("[Cola,1500,20];[Soda,1000,10]")

        println("Please enter the amount of money:")
        println("3000")
        println("Inserted amount: 3000 KRW")
        println("Please enter the name of the product to purchase:")
        println("Cola")
        println("Inserted amount: 1500 KRW")
        println("Please enter the name of the product to purchase:")
        println("Soda")
        //println("Soda")

    }

    private fun promptAmount(inputView: InputView): Int {
        val validators = listOf(IntegerValidator(), DivisibleByValidator(COIN_DIVISOR))
        val combinedValidator = CombinedValidator<Int>(validators)
        val amountPrompter = Prompter(inputView, AMOUNT_PROMPT_TEXT, combinedValidator)
        return amountPrompter.prompt()
    }

}

fun main() {
    val app = Application()
    app.main()
}

