package vendingmachine

object OutputView {
    fun displayCoins(coins: Map<Coin, Int>) {
        println("\nCoins in the vending machine:")
        for (entry in coins) {
            println("${entry.key.amount} KRW - ${entry.value}")
        }
    }
}