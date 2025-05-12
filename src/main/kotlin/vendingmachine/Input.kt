package vendingmachine

import camp.nextstep.edu.missionutils.Console

class InputView(private val outputView: OutputView) {
    fun machineCoins(): String {
        outputView.promptCoins()
        return Console.readLine()
    }

    fun product(): String {
        outputView.promptProduct()
        return Console.readLine()
    }

    fun clientMoney(): String {
        outputView.promptClientMoney()
        return Console.readLine()
    }

    fun productPurchase(): String {
        outputView.promptProductPurchase()
        return Console.readLine()
    }

}

class InputValidator {
    fun validateMachineCoins(input: String): Int {
        val amount = input.toIntOrNull() ?:
        throw ValidationException("The amount the vending machine holds must be a number.")
        require(amount > 0) { "The amount the vending machine holds must be positive." }
        require(amount % 10 == 0) { "The amount the vending machine holds must be divisible by 10." }

        return amount
    }
}

class ValidationException(message: String) : IllegalArgumentException(message)