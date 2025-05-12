package view

object Parser {
    fun vendingMachineAmount(input: String): Int {
        val amount = input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be numeric")
        require(amount > 0 && amount % 10 == 0) { "[ERROR] Amount must be positive and be divisible by 10" }
        return amount
    }
}