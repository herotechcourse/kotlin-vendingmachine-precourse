package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun initialAmountInput():Int {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()
        return try{
        val initialAmount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be a number.")
        require(initialAmount > 0) {"[ERROR] Amount must be greater than 0"}
        initialAmount
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            initialAmountInput()
        }
    }
}