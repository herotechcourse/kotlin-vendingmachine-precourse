package vendingmachine

class Validator {
    fun isCoinAmountValid(amountToCheck: String): Int {
        val number = cleanStringFromSpace(amountToCheck).toIntOrNull() ?:
        throw IllegalArgumentException("Amount must be a number.")
        if (number < 0 ) {
            throw IllegalArgumentException("Amount must be a positive number.")
        }
        if (number % 10 != 0){
            throw IllegalArgumentException("Amount must be divisible by 10.")
        }
        return number
    }

    fun cleanStringFromSpace(input: String):String
    {
        val inputCleaned = input.replace(" ","")
        return inputCleaned
    }
}