package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

class InputView() {
    fun getCoinBalance(): String {
        return getInput(ASK_COIN_BALANCE)
    }

    private fun getInput(prompt: String): String{
        println(prompt)
        return Console.readLine()
    }

    companion object {
       const val ASK_COIN_BALANCE = "Enter the amount the vending machine holds:"

    }

}