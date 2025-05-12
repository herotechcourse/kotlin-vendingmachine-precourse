package vendingmachine

interface InputValidator {
    fun validateInitialAmount(initialAmountInput: String): Int
}

class  InputValidatorImpl : InputValidator{
    override fun validateInitialAmount(initialAmountInput: String): Int {
        try {
            val initialAmount = initialAmountInput.toInt()
            require(initialAmount >= 10 && initialAmount % 10 == 0) { INITIAL_AMOUNT_ERROR_MESSAGE}
            return initialAmount
        }catch (e: NumberFormatException){
            throw IllegalArgumentException(INITIAL_AMOUNT_ERROR_MESSAGE)
        }
    }

    companion object{
        private const val INITIAL_AMOUNT_ERROR_MESSAGE = "Amount must be greater than or equal to 10 and divisible by 10."
    }
}