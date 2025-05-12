package view

import camp.nextstep.edu.missionutils.Console

object InputView {

    private fun readInput(): String {
        return Console.readLine()
    }

    private fun validateInputNotEmpty(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] Input can not be empty.")
        }
    }

    private fun validateDivisibleByTen(input: Int) {
        if (input % 10 != 0) {
            throw IllegalArgumentException("[ERROR] Input must be divisible by 10.")
        }
    }

    private fun tryToInt(input: String): Int {
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Input must be a number.")
        }
    }

    private fun readAndValidateChangeInventory(): Int {
        println("Enter the amount the vending machine holds:")
        val input = readInput()
        validateInputNotEmpty(input)
        val amount = tryToInt(input)
        validateDivisibleByTen(amount)
        return amount
    }

    fun getChangeInventory(): Int {
        while (true) {
            try {
                return readAndValidateChangeInventory()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}