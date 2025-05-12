package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.exception.VendingMachineException.InvalidInputException

object InputView {
    fun readVendingMachineAmount(): Int {
        println(Constants.VENDING_AMOUNT_PROMPT)
        val input = Console.readLine()?.trim() ?: throw InvalidInputException()
        if (input.isEmpty()) throw InvalidInputException()
        return input.toIntOrNull() ?: throw InvalidInputException()
    }

    fun readProducts(): List<String> {
        println(Constants.VENDING_PRODUCTS_PROMPT)
        val input = Console.readLine()?.trim() ?: throw InvalidInputException()
        if (input.isEmpty()) throw InvalidInputException()
        val products = input.split(";")
        if (products.isEmpty()) throw InvalidInputException()
        return products
    }

    fun readClientAmount(): Int {
        println(Constants.USER_AMOUNT)
        val input = Console.readLine()?.trim() ?: throw InvalidInputException()
        if (input.isEmpty()) throw InvalidInputException()
        val amount = input.toIntOrNull() ?: throw InvalidInputException()
        if (amount < 100) throw InvalidInputException()
        return amount
    }

    fun readClientProduct(currentAmount: Int): String {
        println("${Constants.INSERTED_AMOUNT} $currentAmount KRW")
        println(Constants.PRODUCT_NAME_PROMPT)
        val input = Console.readLine()?.trim() ?: throw InvalidInputException()
        if (input.isEmpty()) throw InvalidInputException()
        return input.lowercase().replaceFirstChar { it.uppercase() }
    }

    object Constants {
        const val VENDING_AMOUNT_PROMPT = "Enter the amount the vending machine holds:"
        const val VENDING_PRODUCTS_PROMPT = "Enter product names, prices, and quantities:"
        const val USER_AMOUNT = "Please enter the amount of money:"
        const val INSERTED_AMOUNT = "Inserted amount:"
        const val PRODUCT_NAME_PROMPT = "Please enter the name of the product to purchase:"
    }
}