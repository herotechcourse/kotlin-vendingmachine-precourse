package vendingmachine

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    companion object {
        fun valuesDescending(): List<Coin> =
            values().sortedByDescending { it.amount }

        fun fromAmount(amount: Int): Coin? =
            values().firstOrNull { it.amount == amount }

        fun isValid(amount: Int): Boolean =
            values().any { it.amount == amount}
    }
}
