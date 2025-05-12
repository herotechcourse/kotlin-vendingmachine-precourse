package view
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readVendingMachineAmount(): Int =
        retry("Enter the amount the vending machine holds:") {
            Parser.vendingMachineAmount(Console.readLine())
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