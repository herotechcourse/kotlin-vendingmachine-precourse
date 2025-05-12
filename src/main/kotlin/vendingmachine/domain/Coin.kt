package vendingmachine.domain

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    // TODO: Implement additional functions
    companion object {
        fun from(amount: Int, ): Any {
            return when {
                amount == 500 -> COIN_500
                amount == 100 -> COIN_100
                amount == 50 -> COIN_50
                amount == 10 -> COIN_10
                else -> {}
            }
        }
    }
}
