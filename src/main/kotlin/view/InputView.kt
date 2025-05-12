package view
import vendingmachine.Product
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readVendingMachineAmount(): Int =
        retry("Enter the amount the vending machine holds:") {
            Parser.vendingMachineAmount(Console.readLine())
        }

    fun readListOfProduct(): List<String> =
        retry("Enter product names, prices, and quantities:") {
            Parser.listOfProduct(Console.readLine())
        }

    fun readAmount(): Int =
        retry("Please enter the amount of money:") {
            Parser.readMoneyAmount(Console.readLine())
        }

    private inline fun <T> retry(prompt: String, block: () -> T): T {
        while (true) {
            try {
                println(prompt)
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}