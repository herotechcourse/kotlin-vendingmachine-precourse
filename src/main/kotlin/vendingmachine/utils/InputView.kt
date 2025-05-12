package vendingmachine.utils

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readVendorMachineMoney(): Int {
        while (true) {
            try {
                println("Enter the amount the vending machine holds:")
                val amount = Console.readLine()?: throw IllegalArgumentException("Input cannot be empty")
                return parseVendorMachineMoney(amount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        }

    }

    private fun parseVendorMachineMoney(
        amount: String
    ): Int {
        val moneyHold = amount.toIntOrNull() ?: throw IllegalArgumentException("[Error] Input must be a valid positive number")
        require(moneyHold > 0) { "[Error] Number of rounds must be positive" }
        require(moneyHold % 10 == 0) {"[Error] Amount must be divisible by 10"}
        return moneyHold
    }

}