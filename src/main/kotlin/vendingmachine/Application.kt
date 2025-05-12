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
        println(amount)

        // hard-coded winning numbers and bonus ball for testing
        println("Coins in the vending machine:")
        println("500 KRW - 0")
        println("100 KRW - 4")
        println("50 KRW -1")
        println("10 KRW - 0")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets")
        println("Inserted amount: 3000 KRW")
        println("Inserted amount: 1500 KRW")
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

