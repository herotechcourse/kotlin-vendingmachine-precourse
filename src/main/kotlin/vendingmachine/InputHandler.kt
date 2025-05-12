package vendingmachine

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    companion object {
        private const val MIN_AMOUNT_MACHINE_HOLD = 10

    }

    fun getAmountMachineHold(): Int {
        while (true) try {
            val amountMachineHold = Console.readLine().trim().toInt()
            require(amountMachineHold >= MIN_AMOUNT_MACHINE_HOLD) { "MIN_AMOUNT_MACHINE_HOLD}KRW." }

            return amountMachineHold
        } catch (e: NumberFormatException) {
            println("[ERROR] Enter a valid number.")
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }

}