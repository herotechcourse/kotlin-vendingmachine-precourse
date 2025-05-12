package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class Machine(private val amountHolding: Int) {

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

    fun getCoinInfo(coin: Coin): String {
        return "${coin.amount} KRW - ${coinBoard[coin]}"
    }
}