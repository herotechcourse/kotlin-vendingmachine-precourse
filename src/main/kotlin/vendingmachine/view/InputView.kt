package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readCoinAmount(): Int {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()

        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid integer.")

        return amount

    }


    fun readProducts():List<String> {
        println("Enter product names, prices, and quantities:")
        val input = Console.readLine()
        if (input.isNullOrBlank()) throw IllegalArgumentException("Input cannot be blank.")
        val products = input.split(";").map { it.trim() }


        return products
    }


    fun readAmountOfMoneyInserted(): Int {
        println("Please enter the amount of money:")
        val input = Console.readLine()
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid integer.")


        return amount
    }

    fun buyProduct(): String {
        println("Please enter the name of the product to purchase:")
        val input = Console.readLine()
        if (input.isNullOrBlank()) throw IllegalArgumentException("Input cannot be blank.")

        return input
    }

}