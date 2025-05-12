package vendingmachine

import vendingmachine.view.InputView

fun main() {
    val inputView = InputView()
    val amount = retryUntilSuccess { inputView.inputAmount() }
    val test = inputView.productInput()
    println(test)

}

/**
 * Utility function that repeatedly runs the given block until it succeeds.
 * Catches [IllegalArgumentException], prints error message , and prompts again.
 */
fun <T> retryUntilSuccess(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
