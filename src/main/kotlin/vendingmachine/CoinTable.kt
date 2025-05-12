package vendingmachine

class CoinTable(private val coins: List<Coin>) {

    fun getCoinCount() : Map<Coin, Int> {
        return coins.groupingBy { it }.eachCount()
    }
}