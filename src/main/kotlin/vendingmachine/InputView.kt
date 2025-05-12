package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {
    /**
     * Repeatedly reads and returns a valid purchase amount from user input.
     * Only accepts values divisible by 10.
     * @return {amount} Int
     */
    fun readValidVendingMachineAmount(): Int {
        while (true) {
            try {
                return readCurrency("Enter the amount the vending machine holds:")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readValidProducts(): MutableMap<String, List<Int>> {
        while (true) {
            try {
                return readProducts()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readValidPurchaseAmount(): Int {
        while (true) {
            try {
                return readCurrency("Please enter the amount of money:")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readValidProductName(): String {
        while (true) {
            try {
                return readProductName()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readProducts(): MutableMap<String, List<Int>> {
        println("Enter product names, prices, and quantities:")
        val input = Console.readLine()
        return InputValidator.parseProducts(input)
    }

    private fun readCurrency(inputMessage: String): Int {
        println(inputMessage)
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a valid number.")
        InputValidator.validateVendingMachineAmount(amount)
        return amount
    }

    private fun readProductName(): String {
        println("Please enter the name of the product to purchase:")
        val input = Console.readLine()
        return input
    }
}