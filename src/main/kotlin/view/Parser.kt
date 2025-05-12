package view

object Parser {
    fun vendingMachineAmount(input: String): Int {
        val amount = input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be numeric")
        require(amount > 10 && amount % 10 == 0) { "[ERROR] Amount must be greater than 10 and divisible by 10" }
        return amount
    }

    fun listOfProduct(input: String): List<String> {
        require(input.isNotEmpty()) { "[ERROR] List of products input is empty" }
        return input.split(";")
                    .onEach { require(it.isNotEmpty()) { "Product is empty" } }
                    .map { it.trim().removeSurrounding("[", "]") }.onEach { println(it) }
    }

    fun readMoneyAmount(input: String): Int {
        val amount = input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be numeric")
        require(amount > 0) { "[ERROR] Amount must be positive number" }
        return amount
    }
}