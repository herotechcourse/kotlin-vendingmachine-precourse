package vendingmachine.presentation

import camp.nextstep.edu.missionutils.Console

interface InputView {
    fun readInitialAmount(): String
    fun readListOfProducts(): String
    fun readInsertedAmount(): String
    fun readProductName(): String
}

class InputViewImpl : InputView{
    override fun readInitialAmount(): String {
        return Console.readLine()
    }

    override fun readListOfProducts(): String {
        return Console.readLine()
    }

    override fun readInsertedAmount(): String {
        return Console.readLine()
    }

    override fun readProductName(): String {
        return Console.readLine()
    }

}