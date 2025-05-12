package vendingmachine

object OutputView {
    fun printCoinsInMachine(coinMap : MutableMap<Int, Int>) {

        coinMap.forEach { entry ->
            println("${entry.key} KRW - ${entry.value}")
        }
    }

    fun printUnableToReturn(initialAmount:Int, remainingAmount:Int) {
        if (initialAmount < remainingAmount) {
            val machineAmount = remainingAmount - initialAmount
            println("\nUnable to return: $machineAmount KRW")
        }
    }
}