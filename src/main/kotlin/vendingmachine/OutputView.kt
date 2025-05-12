package vendingmachine

object OutputView {
    fun printGeneratedCoins(coins: MutableMap<Coin, Int>) {
        println("Coins in the vending machine:")
        Coin.entries
            .filter { it != Coin.NONE }
            .forEach { coin ->
                val count = coins.getOrDefault(coin, 0)
                println("${coin.amount} KRW - $count")
            }
    }

    fun printChangeCoins(coins: MutableMap<Coin, Int>) {
        println("Change returned:")
        Coin.entries
            .filter { it != Coin.NONE }
            .forEach { coin ->
                val count = coins.getOrDefault(coin, 0)
                if (count > 0) {
                    println("${coin.amount} KRW - $count")
                }
            }
    }

    fun printInsertedAmount(amount: Int) {
        println("Inserted amount: $amount KRW")
    }

    fun printUnableToReturn(amount: Int) {
        println("Unable to return: $amount KRW")
    }
}