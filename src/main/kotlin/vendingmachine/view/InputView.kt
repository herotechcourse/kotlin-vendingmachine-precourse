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

    object Constants {
        const val VENDING_AMOUNT_PROMPT = "Enter the amount the vending machine holds:"
        const val VENDING_COINS = "Coins in the vending machine:"
        const val USER_AMOUNT = "Please enter the amount of money:"
        const val INSERTED_AMOUNT = "Inserted amount:"
        const val PRODUCT_NAME_PROMPT = "Please enter the name of the product to purchase:"
        const val CHANGE_RETURNED = "Change returned:"
        const val UNABLE_TO_RETURN = "Unable to return:"
    }
}