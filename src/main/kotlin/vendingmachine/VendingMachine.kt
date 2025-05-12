package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class VendingMachine {
    private val coins = mutableMapOf<Coin, Int>()
    private val products = mutableListOf<Product>()
    private var userBalance = 0

    fun generateCoins(amount: Int) {
        Coin.values().forEach { coins [it] = 0 }
        var remaining = amount

        while (remaining >= 10) {
            val coin = Coin.from(Randoms.pickNumberInList(Coin.asList())) ?: continue
            if (remaining >= coin.amount) {
                coins[coin] = coins[coin]!! + 1
                remaining -= coin.amount
            }
        }
    }
    fun getCoinInventory(): Map<Coin, Int> = coins

    fun setProducts(items : List<Product>) {
        products.clear()
        products.addAll(items)
    }
    fun insertMoney(amount : Int) {
        userBalance = amount
    }
    fun getUserBalance() = userBalance
}