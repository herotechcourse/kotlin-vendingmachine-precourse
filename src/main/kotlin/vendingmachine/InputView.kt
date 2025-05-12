package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {
    /**
     * Repeatedly reads and returns a valid purchase amount from user input.
     * Only accepts values divisible by 10.
     * @return {amount} Int
     */
    fun readValidVendingMachineAmount():Int {
        while (true) {
            try {
                return readVendingMachineAmount()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readValidProducts():MutableMap<String, List<Int>>{
        while (true) {
            try {
                return readProducts()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    /**
     * Read the value and returns the amount
     */
    private fun readVendingMachineAmount():Int {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a valid number.")
        InputValidator.validateVendingMachineAmount(amount)
        return 0
    }

    private fun readProducts():MutableMap<String, List<Int>> {
        println("Enter product names, prices, and quantities:")
        val input = Console.readLine()
        return InputValidator.parseProducts(input)
    }
}