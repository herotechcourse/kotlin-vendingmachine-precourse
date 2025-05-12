package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCoinAmount(): Int {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid integer.")
    }

    fun readProducts(): List<String> {
        println("Enter product names, prices, and quantities:")
        val input = Console.readLine()
        if (input.isBlank()) throw IllegalArgumentException("[ERROR] Input cannot be blank.")
        return input.split(";").map { it.trim() }
    }

    fun readAmountOfMoneyInserted(): Int {
        println("Please enter the amount of money:")
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid integer.")
    }

    fun buyProduct(): String {
        println("Please enter the name of the product to purchase:")
        val input = Console.readLine()
        if (input.isBlank()) throw IllegalArgumentException("[ERROR] Input cannot be blank.")
        return input
    }
}