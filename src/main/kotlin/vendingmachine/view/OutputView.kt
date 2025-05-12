package vendingmachine

// import lotto.Application.Companion.Prize

class OutputView {
    /**
     * Prints the purchased tickets.
     */
    fun printCoins(conins: List<List<Int>>) {
        println("Coins in the vending machine:")
        coins.forEach { println(it) }
        println()
    }

    /**
     * Prints the error message to console.
     */
    fun printError(message: String) {
        println(message)
    }

    /**
     * Prints the winning statistics.
     */
    // fun printWinningStatistics(results: Map<Prize, Int>) {
    //     println("Winning Statistics")
    //     println("---")
    //     results.forEach { (prize, count) ->
    //         if (prize == Prize.MATCH_FIVE_BONUS) {
    //             println("5 Matches + Bonus Ball (${"%,d".format(prize.amount)} KRW) – $count tickets")
    //             return@forEach
    //         }
    //         println("${prize.matches} Matches (${"%,d".format(prize.amount)} KRW) – $count tickets")
    //     }
    // }

    // /**
    //  * Prints the total return rate.
    //  */
    // fun printTotalReturnRate(totalReturnRate: Double) {
    //     val formatted = "%.1f".format(totalReturnRate)
    //     println("Total return rate is $formatted%.")
    // }
}
