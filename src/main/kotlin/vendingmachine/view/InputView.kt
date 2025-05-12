package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readProductInput(): String {
        while (true) {
            try {
                println("Enter product names, prices, and quantities")
                val input = Console.readLine().trim()
                require(input.isNotBlank()) { "Product input cannot be empty" }
                return input
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun readMachineCoinAmount(): Int {
        while (true) {
            try {
                println("Enter the amount the vending machine holds:")
                return Console.readLine().trim().toInt().also {
                    require(it >= 0 && it % 10 == 0) { "[ERROR] Amount must be a multiple of 10 or 0" }

                }
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun readInsertedAmount(): Int {
        while (true) {
            try {
                println("Please enter the amount of money:")
                return Console.readLine().trim().toInt().also {
                    require(it >= 0 && it % 10 == 0) { "Inserted amount must be a multiple of 10" }
                }
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun readProductNames(): String{
        println("Please enter the name of the product to purchase:")
        return Console.readLine().trim()
    }
}