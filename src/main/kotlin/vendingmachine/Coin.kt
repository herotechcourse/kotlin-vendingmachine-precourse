package vendingmachine

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    override fun toString(): String {
        return "${amount.toString()} KRW"
    }
}
