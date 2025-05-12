package vendingmachine

object OutputView {
    fun printCoinsInMachine(coinMap : MutableMap<Int, Int>) {
        println("\nCoins in the vending machine:")
        coinMap.forEach { entry ->
            println("${entry.key} KRW - ${entry.value}")
        }
    }
}