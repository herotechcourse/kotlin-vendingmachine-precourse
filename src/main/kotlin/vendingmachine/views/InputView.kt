package vendingmachine.views

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readVendingMachineAmount(): Int = promptAgain {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()
        val readInput = input.toIntOrNull()

        if (readInput == null || readInput < 0 || readInput % 10 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be positive and divisible by 10.")
        }

        readInput
    }

    private fun <T> promptAgain(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}