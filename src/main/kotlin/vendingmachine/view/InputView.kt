package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputAmount(): Int {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

        require(amount > 0) {
            "[ERROR] Amount must be a positive number."
        }

        return amount
    }

    fun productInput(): List<String> {
        println("Enter product names, prices, and quantities:")
        val input = Console.readLine()
        val groupOfProducts = input.split(";").map { it.trim() }
        for ( x in groupOfProducts) {
            val itemsList = x.replace("[", "").replace("]", "").split(",").map { it.trim() }
            println(itemsList)
        }

        return groupOfProducts
    }

}