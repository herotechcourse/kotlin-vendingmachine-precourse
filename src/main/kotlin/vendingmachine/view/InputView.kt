package vendingmachine.view

import vendingmachine.service.Validator
import camp.nextstep.edu.missionutils.Console

object InputView {

    fun input1(): String {
        val amount = Console.readLine().trim()
//        try {
//            // Validate(1): T.B.D.
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//            return input1()
//        }
        return amount
    }

    fun input4 (): String {
        val product = Console.readLine().trim()
        try {
            Validator.validateProductForm(product)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return input4()
        }
        return product
    }

    fun input5 (): String {
        val input = Console.readLine()
//        try {
//            // Validator
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//            return input5()
//        }
        return input
    }

    fun input7 (): String {
        val input = Console.readLine()
        try {
            Validator.validateOnlyNumber(input)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return input7()
        }
        return input
    }
}