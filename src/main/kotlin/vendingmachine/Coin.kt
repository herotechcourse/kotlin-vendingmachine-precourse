package vendingmachine

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),
    NONE(0);

    companion object {
        fun matching(amountMatch: Int): Coin {
            return when (amountMatch) {
                500 -> COIN_500
                100 -> COIN_100
                50 -> COIN_50
                10 -> COIN_10
                else -> NONE
            }
        }
    }
}
