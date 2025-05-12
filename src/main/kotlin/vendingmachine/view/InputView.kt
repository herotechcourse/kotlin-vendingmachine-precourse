package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val readLine: () -> String = { Console.readLine() }

    fun readAmountHolds(): List<Int> {
        while (true) {
            println("Enter the amount the vending machine holds:")
            try {
                val input = readLine().trim()
                return input.map { it.digitToInt() }
            } catch (e: IllegalArgumentException) {
                println("Please try it again")
            }

        }
    }

    // TODO( "Enter product names, prices, and quantities")


    fun amountOfMoney(): List<Int> {
        while (true) {
            println("Please enter the amount of money:")
            try {
                val input = readLine().trim()
                return input.map { it.digitToInt() }
            } catch (e: IllegalArgumentException) {
                println("Please try it again")
            }
        }
    }

    fun nameOfTheProduct(): List<Int> {
        while (true) {
            println("Please enter the name of the product to purchase:")
            try {
                val input = readLine().trim()
                return input.map { it.digitToInt() }
            } catch (e: IllegalArgumentException) {
                println("Please try it again")
            }
        }
    }


    fun secondNameOfTheProduct() {

        nameOfTheProduct()

    }

    companion object {
        fun readAmountHolds() {

        }
    }
}






