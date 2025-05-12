package vendingmachine

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getBalance(): Int {
        println()
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        return amount
    }

    fun getProducts(): List<Product> {
        val list =  mutableListOf<Product>()
        println()
        println("Enter product names, prices, and quantities:")
        val input = Console.readLine()
        require(input.contains('[')) {"[ERROR] Invalid format, must contain []" }
        require(input.contains(',')) {"[ERROR] Invalid format, must be separated by commas" }
        require(input.contains(';')) {"[ERROR] Invalid format, lists must be separated by semi-colons" }
        val parsed = input.split(';')
        // to be continued...
    }

    fun getMoney(): Int {
        println()
        println("Please enter the amount of money:")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        return amount
    }

    fun sell(): String {
        println("Please enter the name of the product to purchase:")
        val input = Console.readLine()
        return input
    }
}