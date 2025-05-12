package vendingmachine.validator

object Validator {
    private fun validateNonEmpty(input: String, errorMessage: String) {
        if (input.trim().isEmpty()) {
            throw IllegalArgumentException(errorMessage)
        }
    }

    fun validateInitialAmount(input: String): Int {
        validateNonEmpty(input, "[ERROR] Input cannot be empty.")

        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        require(amount > 0 && amount % 10 == 0) { "[ERROR] Amount must be divisible by 1000" }
        
        return amount
    }

    fun validateInitialChange(input: String): Int {
        validateNonEmpty(input, "[ERROR] Input cannot be empty.")

        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        require(amount > 0 && amount % 10 == 0) { "[ERROR] Amount must be divisible by 1000" }
        
        return amount
    }

    fun validateProducts(input: String): List<String> {
        validateNonEmpty(input, "[ERROR] Input cannot be empty.")

        return parseInputBySemicolon(input)
    }

    fun validatePurchaseProduct(input: String): String {
        validateNonEmpty(input, "[ERROR] Input cannot be empty.")

        return parseInputBySemicolon(input)
    }


    fun parseInputBySemicolon(input: String): List<String> {
        val products = input.split(";").map { it.trim() }
        
        return products;
    }
}