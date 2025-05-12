package vendingmachine

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),
    NONE(amount = 0);

    companion object {
        fun coinFinder(amount: Int): Coin {
            if (amount == 500) return COIN_500
            if (amount == 100) return COIN_100
            if (amount == 50) return COIN_50
            if (amount == 10) return COIN_10
            return NONE
        }

        fun printCoin(coin: Coin): String {
            if (coin == COIN_500) return "500 KRW"
            if (coin == COIN_100) return "100 KRW"
            if (coin == COIN_50) return "50 KRW"
            if (coin == COIN_10) return "10 KRW"
            return ""
        }

    }
}
