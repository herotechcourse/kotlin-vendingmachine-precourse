package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputValidator {

    fun getVendingMachineAmount(): Int {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()
        return validateVendingMachineAmount(input)
    }

    fun validateVendingMachineAmount(input: String): Int {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("Amount must be a number.")
        return amount
    }

    fun getValidProducts(): List<String> {
        println("Enter product names, prices, and quantities, separated with a space:")
        val input = Console.readLine()
        val products = input.split(' ').toList()
        return products
    }
}
