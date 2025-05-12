package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getInitialAmount(): Int {
        println("Enter the amount the vending machine holds:")
        val amount = Console.readLine().trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR]: input has to be an integer")
        return amount
    }

    fun getInventory(): List<List<String>> {
        println("\nEnter product names, prices, and quantities:")
        val input = Console.readLine().trim().split(";")
        require(input.isNotEmpty()) { "[ERROR]: input cannot be empty" }
        val inventory: MutableList<List<String>> = mutableListOf()
        for (str in input) {
            inventory.add(splitInventory(str))
        }
        return inventory.toList()
    }

    private fun splitInventory(string: String): List<String> {
        require(string.isNotEmpty() && string.startsWith('[') && string.endsWith(']')) {
            "[ERROR]: invalid input format"
        }
        val list = string.trim('[', ']').split(",")
        require(list.size == 3) { "[ERROR]: invalid input format" }
        for (elem in list) {
            require(elem.isNotEmpty()) { "[ERROR]: invalid input format" }
        }
        return list
    }

    fun getPurchaseAmount(): Int {
        println("\nPlease enter the amount of money:")
        val input = Console.readLine().trim().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR]: input has to be an integer")
        return input
    }

    fun getProductName(): String {
        println("Please enter the name of the product to purchase:")
        val input = Console.readLine().trim()
        for (char in input) {
            require(char.isLetter()) { "[ERROR]: input can only contain letters" }
        }
        return input
    }
}