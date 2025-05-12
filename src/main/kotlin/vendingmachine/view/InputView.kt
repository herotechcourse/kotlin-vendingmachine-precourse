package vendingmachine

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun showPrompt(promptMessage: String) {
        println(promptMessage)
    }

    fun readInput(): String = Console.readLine()

    fun showError(errorMessage: String) {
        println(errorMessage)
    }
}
