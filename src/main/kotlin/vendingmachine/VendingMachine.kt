package vendingmachine

data class VendingMachine(var balance: Int = 0, var products: List<Product> = emptyList() ){
    fun getCoinsHeld(): List<Coin> {
        val value = balance
        val list = mutableListOf<Coin>()
        while (value > 0) {
            if (value - 500 > 0)
                list.add(Coin.COIN_500)
            else if (value - 100 > 0)
                list.add(Coin.COIN_100)
            else if (value - 50 > 0)
                list.add(Coin.COIN_50)
            else if (value - 10 > 0)
                list.add(Coin.COIN_10)
        }
        return list
    }

    fun getProduct(itemName: String): Product {
        val item = products.find { it.name == itemName } ?: throw IllegalArgumentException("[ERROR] Product not found!")
        return item
    }

    fun canPurchase(): Boolean {
        val cheapest = getCheapest()
        val stockStatus = checkStock()
        if (balance > cheapest && stockStatus)
            return true
        return false
    }

    fun returnChange(): List<Coin> {
        val list = mutableListOf<Coin>()
        while(balance > 0) {
            val coin = Coin.generateCoin(balance)
            if (coin.amount >= balance)
                return list
            list.add(coin)
        }
        return list
    }

    private fun getCheapest(): Int {
        var cheap = products[0].price
        for (item in products) {
            if (item.price < cheap)
                cheap = item.price
        }
        return cheap
    }

    private fun checkStock(): Boolean {
        var stockAvailable = false
        for (item in products) {
            if (item.quantity == 0)
                stockAvailable = true
        }
        return stockAvailable
    }
}