package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.util.Validator

class InputView {
    val validator = Validator()

    fun inputMachineBalance(): Int {
        println(Messages.MACHINE_AMOUNT)
        while (true){
            try {
                val input: String = Console.readLine()
                return validator.isValidBalanceInput(input)
            }
            catch (e : Exception) {
                println(e.message)
            }
        }
    }

    companion object Messages {
        const val MACHINE_AMOUNT = "Enter the amount the vending machine holds:"
    }
}