package vendingmachine.util

class Validator {

    fun isValidBalanceInput(input: String): Int {
        val balance = input.toIntOrNull()
        if (balance == null || balance % 10 != 0 || balance < 10)
            throw IllegalArgumentException(ErrorMessages.INVALID_AMOUNT)
        return balance
    }

    companion object ErrorMessages {
        const val INVALID_AMOUNT= "[Error] Amount must be a positive number divisible by 10"
    }
}