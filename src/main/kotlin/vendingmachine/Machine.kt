package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class Machine(private val amountHolding: Int) {
    private var _remaining: Int = 0
    val remaining: Int
        get() = _remaining

    private var _coinBoard: MutableMap<Coin, Int> = mutableMapOf()
    val coinBoard: Map<Coin, Int>
        get() = _coinBoard

    private var _products = mutableListOf<Product>()
    val products: List<Product>
        get() = _products

    init {

        Coin.entries.forEach { _coinBoard[it] = 0 }
        generateCoins()
    }

    private fun generateCoins() {
        var remaining = amountHolding
        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount
                val coin = Coin.getMatching(amount)
                _coinBoard[coin] = _coinBoard.getOrDefault(coin, 0) + 1
            }
        }
    }

    fun setProducts(products: List<Product>) {
        _products = products.toMutableList()
    }

    fun setRemaining(remaining: Int) {
        _remaining = remaining
    }

    fun getCoinInfo(coin: Coin): String {
        return "${coin.amount} KRW - ${coinBoard[coin]}"
    }

    fun getRemainingInfo(): String {
        return "\nInserted amount: $_remaining KRW"
    }

    fun processOrder(targetProduct: Product) {
        _remaining -= targetProduct.price
        targetProduct.reduceQuantityOne()
    }

    fun isAnyAvailable(): Boolean = products.sumOf { it.getQuantity() } > 0

    fun isOneAvailable(product: Product) {}

    // TODO: Well unfortunate unfinished work
    fun letsFinish() {
        var usedCoins: MutableMap<Coin, Int> = mutableMapOf()
        Coin.entries.forEach { usedCoins[it] = 0 }

        var toReturn = remaining

//        while (_coinBoard.values.sum() != 0 || toReturn != 0)
        for (coin in Coin.entries) {
            val targetCoinAmount = _coinBoard.getOrDefault(coin, 0)
            val usedCoinAmount = usedCoins.getOrDefault(coin, 0)
            while (targetCoinAmount > 0) {
                if (_coinBoard.values.sum() == 0 || toReturn == 0) { break }
                toReturn -= coin.amount
                _coinBoard[coin] = targetCoinAmount - 1
                usedCoins[coin] = usedCoinAmount + 1
            }
        }
        return TODO("Well...")
    }
}