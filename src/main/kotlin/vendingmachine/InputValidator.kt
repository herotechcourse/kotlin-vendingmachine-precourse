package vendingmachine

object InputValidator {
    fun validateVendingMachineAmount(amount: Int) {
        isDivisibleByTen(amount)
    }

    fun parseProducts(input: String): MutableMap<String, List<Int>> {
        val data = input.split(';')
        if (data.isEmpty()) throw IllegalArgumentException("[ERROR] At least one product is required")
        val res = data.map { product -> parseEachObject(product) }
        val hash = productHash(res)
        return hash
    }

    private fun parseEachObject(input: String): List<String> {
        if (input.first() != '[' || input.last() != ']') throw IllegalArgumentException("[ERROR] Syntax error of Product")

        val data = input.substring(1, input.length - 1).split(',')
        if (data.size != 3) throw IllegalArgumentException("[ERROR] Product is missing one or more attributes")

        return data
    }

    private fun productHash(input: List<List<String>>): MutableMap<String, List<Int>> {
        val res = mutableMapOf<String, List<Int>>()
        for (item in input) {
            res[item[0]] = createProductData(item[1], item[2])
        }
        return res
    }

    private fun createProductData(price: String, quantity: String): List<Int> {
        val parsedQuantity = convertValidInteger(quantity)
        val parsedPrice = convertValidInteger(price)
        isDivisibleByTen(parsedPrice)
        isGreaterThan100(parsedPrice)
        checkGreaterThanZero(parsedQuantity)
        return listOf(parsedPrice, parsedQuantity)
    }

    private fun convertValidInteger(input: String): Int {
        return input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
    }

    private fun isDivisibleByTen(amount: Int) {
        if (amount % 10 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 10.")
    }

    private fun isGreaterThan100(amount: Int) {
        if (amount < 100) throw IllegalArgumentException("[ERROR] Amount must be greater than 100.")
    }

    private fun checkGreaterThanZero(num: Int) {
        if (num <= 0) throw IllegalArgumentException("[ERROR] Quantity should be greater then zero")
    }
}