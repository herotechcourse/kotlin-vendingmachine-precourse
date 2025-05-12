package vendingmachine

object OutputView {
    fun displayCoins(coins: Map<Coin, Int>) {
        println("\nCoins in the vending machine:")
        for (entry in coins) {
            println("${entry.key.amount} KRW - ${entry.value}")
        }
    }

    fun displayInsertedAmount(amount: Int) {
        println("\nInserted amount: $amount KRW")
    }

    fun displayChange(change: Map<Coin, Int>, balance: Int) {
        println("\nChange returned:")
        for (entry in change) {
            println("${entry.key.amount} KRW - ${entry.value}")
        }

        println("\nUnable to return $balance KRW")
    }

}