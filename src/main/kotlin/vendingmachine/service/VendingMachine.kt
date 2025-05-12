package vendingmachine.service
import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.domain.Coin
import vendingmachine.domain.Product

class VendingMachine(initialAmount: Int) {
    private val coinInventory: MutableMap<Coin, Int> = mutableMapOf()
    private val products: MutableList<Product> = mutableListOf()
    private var userBalance: Int = 0

    init {
        coinInventory.putAll(generateCoins(initialAmount))
    }

    private fun generateCoins(amount: Int): Map<Coin, Int> {
        val result = mutableMapOf<Coin, Int>()
        var remaining = amount
        val denominations = Coin.valuesDescending.map { it.amount }

        while (remaining >= 10) {
            val coinAmount = Randoms.pickNumberInList(denominations)
            if (remaining >= coinAmount) {
                val coin = Coin.from(coinAmount)
                result[coin as Coin] = result.getOrDefault(coin, 0) + 1
                remaining -= coinAmount
            }
        }
        return result
    }

    fun setUserBalance(balance: Int) {
        this.userBalance = balance
    }

    fun addProducts(productsToAdd: List<Product>) {
        products.addAll(productsToAdd)
    }

    fun getBalance(): Int = userBalance

    fun purchaseProduct(productName: String): Boolean {
        val product = products.find { it.name == productName } ?: return false
        if (product.quantity <= 0 || userBalance < product.price) return false
        product.quantity -= 1
        userBalance -= product.price
        return true
    }

    fun returnChange(): Pair<Map<Coin, Int>, Int> {
        val changeMap = mutableMapOf<Coin, Int>()
        var remaining = userBalance

        for (coin in Coin.valuesDescending) {
            val available = coinInventory[coin] ?: 0
            val toUse = minOf(remaining / coin.amount, available)
            if (toUse > 0) {
                changeMap[coin] = toUse
                remaining -= toUse * coin.amount
                coinInventory[coin] = available - toUse
            }
        }

        return Pair(changeMap, remaining)
    }

    fun getCoinInventory(): Map<Coin, Int> = coinInventory
}
