package vendingmachine

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),
    NONE(0);

    companion object {
        fun from(amount: Int):Coin{
            return when {
                amount >= 500 -> COIN_500
                amount >= 100 -> COIN_100
                amount >= 50 -> COIN_50
                amount >= 10 -> COIN_10
                else -> NONE
            }
        }
    }
}
