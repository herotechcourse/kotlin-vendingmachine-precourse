package vendingmachine

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    companion object {
        fun from (amount: Int): Coin? = values().find { it.amount == amount }
        fun denominationsDescending() = values().sortedByDescending { it.amount }
        fun asList() = values().map { it.amount }
    }
}
