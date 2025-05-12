package vendingmachine

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),

    companion object {
        val valuesDescending = vales().sortedByDescending {it.amount}
    }
}
