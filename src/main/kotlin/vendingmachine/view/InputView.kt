package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readCoinAmount(): Int {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()

        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid integer.")

        return amount

    }

}