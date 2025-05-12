package vendingmachine

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    companion object {
        fun from(value:Int) = when (value) {
            500 -> COIN_500
            100 -> COIN_100
            50 -> COIN_50
            else -> COIN_10
        }
    }
}
