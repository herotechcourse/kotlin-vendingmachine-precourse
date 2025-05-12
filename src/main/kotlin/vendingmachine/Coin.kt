package vendingmachine

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    // TODO: Implement additional functions
    companion object {
        fun calculate(change: Int): List<Int> {
            var newChange = change
            val coinList = listOf(500, 100, 50, 10)
            val coins = mutableListOf<Int>()

            for (coin in coinList) {
                while (newChange >= coin) {
                    coins.add(coin)
                    newChange -= coin
                }
            }
            println("Coins in the vending machine:")
            coins.groupingBy { it.compareTo(it) }.eachCount()
            return coins
        }
    }
}
