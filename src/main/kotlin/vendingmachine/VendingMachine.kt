package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class VendingMachine(private val _amount: Int) {
    val amount: Int
        get() = _amount

    private val _coins: MutableMap<Coin, Int> = generateCoins()
    val coins: Map<Coin, Int>
        get() = _coins.toMap()

    private var _products: MutableList<Product> = mutableListOf()
    val products: List<Product>
        get() = _products.toList()

    private var _budget: Int = 0
    val budget: Int
        get() = _budget

    init {
        require(amount % 10 == 0) { "[ERROR]: amount has to be divisible by 10" }
        require(amount > 0) { "[ERROR]: amount has to be bigger than 0" }
        // TODO add max amount
    }

    private fun generateCoins(): MutableMap<Coin, Int> {
        val coins = mutableMapOf(Coin.COIN_500 to 0, Coin.COIN_100 to 0, Coin.COIN_50 to 0, Coin.COIN_10 to 0)
        var remaining = _amount
        while (remaining >= 10) {
            val num = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= num) {
                remaining -= num
            }
            // TODO extract to a sep fun
            when(num) {
                500 -> coins[Coin.COIN_500] = coins.getOrDefault(Coin.COIN_500, 0) + 1
                100 -> coins[Coin.COIN_100] = coins.getOrDefault(Coin.COIN_100, 0) + 1
                50 -> coins[Coin.COIN_50] = coins.getOrDefault(Coin.COIN_50, 0) + 1
                10 -> coins[Coin.COIN_10] = coins.getOrDefault(Coin.COIN_10, 0) + 1
            }
        }
        return coins
    }

    fun addProduct(product: Product) {
        for (elem in _products) {
            if (product.productName == elem.productName)
                throw IllegalArgumentException("[ERROR]: product already exists")
        }
        _products.add(product)
    }

    fun initBudget(money: Int) {
        _budget = money
    }

    private fun searchProduct(productName: String): Int {
        for (i in 0 until _products.size) {
            if (_products[i].productName == productName) {
                return i
            }
        }
        throw IllegalArgumentException("[ERROR]: product not found")
    }

    fun purchaseProduct(productName: String) {
        val index = searchProduct(productName)
        if (_budget - _products[index].price >= 0) {
            _budget -= _products[index].price
            _products[index].decreaseQuantity()
        }
        else
            returnChange()
    }

    private fun returnChange() {

    }



}