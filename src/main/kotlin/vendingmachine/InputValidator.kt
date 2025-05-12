package vendingmachine

object InputValidator {
    fun validateVendingMachineAmount(amount:Int) {
        isDivisibleByTen(amount)
    }

    fun parseProducts(input:String):  MutableMap<String, List<Int>> {
        val data = input.split(';')
        if (data.isEmpty()) throw IllegalArgumentException("[ERROR] At least one product is required")
        val res = data.map { product -> parseEachObject(product) }
        val hash = productHash(res)
        return hash
    }

    private fun parseEachObject(input: String):List<String> {
        if (input.first() != '[' || input.last() != ']') throw IllegalArgumentException("[ERROR] Syntax error of Product")

        val data = input.substring(1,input.length - 1).split(',')
        if (data.size != 3) throw IllegalArgumentException("[ERROR] Product is missing one or more attributes")

        return data
    }

    private fun productHash(input: List<List<String>>): MutableMap<String, List<Int>>{
        val res = mutableMapOf<String, List<Int>>()
        for (item in input) {
            val quantity = convertValidInteger(item[2])
            val price = convertValidInteger(item[1])
            isDivisibleByTen(price)
            isGreaterThan100(price)
            res[item[0]] = listOf(price,quantity)
        }
        return res
    }

    private fun convertValidInteger(input: String): Int {
        return input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
    }

    private fun isDivisibleByTen(amount:Int) {
        if (amount % 10 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 10.")
    }

    private fun isGreaterThan100(amount: Int) {
        if (amount < 100) throw IllegalArgumentException("[ERROR] Amount must be greater than 100.")
    }
}