package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readMoneyAmountMachineHold():Int {
        println("Enter the amount the vending machine holds:")
        return Console.readLine()
            .trim()
            .toIntOrNull()?.takeIf { it > 0 && it % 10 == 0}
            ?: throw IllegalArgumentException("[ERROR] Input must be a positive number divisible by 10.")
    }
}