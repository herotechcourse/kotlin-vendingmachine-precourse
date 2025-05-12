package vendingmachine.utils

import camp.nextstep.edu.missionutils.Console
import vendingmachine.core.Product

object InputView {

    fun readVendorMachineMoney(): Int {
        while (true) {
            try {
                println("Enter the amount the vending machine holds:")
                val amount = Console.readLine()?: throw IllegalArgumentException("Input cannot be empty")
                return parseVendorMachineMoney(amount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        }

    }

    private fun parseVendorMachineMoney(
        amount: String
    ): Int {
        val moneyHold = amount.toIntOrNull() ?: throw IllegalArgumentException("[Error] Input must be a valid positive number")
        require(moneyHold > 0) { "[Error] Number of rounds must be positive" }
        require(moneyHold % 10 == 0) {"[Error] Amount must be divisible by 10"}
        return moneyHold
    }

    fun readProductNamePriceQuantity(): List<Product> {
        while (true) {
            try {
                println("\nEnter product names, prices, and quantities:")
                val input = Console.readLine()?: throw IllegalArgumentException("[ERROR] Input cannot be empty")
                return parseProductNamePriceQuantity(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        }
    }

    private fun parseProductNamePriceQuantity(
        input: String
    ): List<Product> {

        val productsList = mutableListOf<Product>()

        val productString = input.split(";")
        productString.forEach {
            val productString = it.replace("[", "").replace("]","").trim().split(",")

            require(productString.size == 3) {"[ERROR] Invalid input"}

            val name = productString.getOrNull(0)?: throw IllegalArgumentException ("[ERROR] Name input invalid")
            val price = productString.getOrNull(1)
                ?.toIntOrNull()
                ?: throw IllegalArgumentException ("[ERROR] Price input invalid")
            require(price >= 100) {throw IllegalArgumentException ("[ERROR] Product price must start at 100 KRW and be divisible by 10") }
            require(price % 10 == 0) {throw IllegalArgumentException ("[ERROR] Product price must start at 100 KRW and be divisible by 10") }
            val quantity = productString.getOrNull(2)
                ?.toIntOrNull()
                ?: throw IllegalArgumentException ("[ERROR] Quantity input invalid")

            val product = Product(
                name,
                price,
                quantity
            )
            productsList.add(product)
        }
        return productsList
    }

    fun readUserAmountOfMoney(): Int {
        while (true) {
            try {
                println("Please enter the amount of money:")
                val amount = Console.readLine()?: throw IllegalArgumentException("Input cannot be empty")
                return parseUserAmountOfMoney(amount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        }

    }

    private fun parseUserAmountOfMoney(
        amount: String
    ): Int {
        val userMoney = amount.toIntOrNull() ?: throw IllegalArgumentException("[Error] Input must be a valid positive number")
        require(userMoney > 0) { "[Error] Number of rounds must be positive" }
        require(userMoney % 10 == 0) {"[Error] Amount must be divisible by 10"}
        return userMoney
    }



}