package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class VendingMachine {
    val availableCoins = mutableMapOf<Coin, Int>()
    var availableProducts = mutableListOf<Product>()
    var userMoneyAmount = 0


    fun initializeCoinInventory(amount: Int) {
        var remaining = amount

        while (remaining >= 10) {
            val coinValue = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= coinValue) {
                remaining -= coinValue
                val count = availableCoins[Coin.coinFinder(coinValue)] ?: 0
                availableCoins[Coin.coinFinder(coinValue)] = count + 1
            }
        }
    }

    fun initializeProductInventory(products: List<Product>) {
        for (product in products) {
            availableProducts.add(product)
        }
    }

    fun initializeUserMoney(amount: Int) {
        userMoneyAmount = amount
    }

    fun purchaseProductFinder(productToPurchase: String): Product {
        for (product in availableProducts) {
            if (product.productName == productToPurchase) {
                return product
            }
        }

        throw IllegalArgumentException("[ERROR] Product doesn't exist in the machine")
    }

    fun purchaseProcessor(productToPurchase: String) {
        val product = purchaseProductFinder(productToPurchase)
        if (userMoneyAmount >= product.productPrice) {
            product.sellProduct()
            userMoneyAmount -= product.productPrice
            return
        }

        throw IllegalArgumentException("[ERROR] You don't have enough money to buy this product")

    }

    fun checkAllSoldout(): Boolean {
        for (product in availableProducts) {
            if (product.productQuantity != 0) {
                return false
            }
        }

        return true
    }

    fun checkEndingConditions(): Boolean {
        var minPrice = Int.MAX_VALUE

        for (product in availableProducts) {
            if (product.productPrice <= minPrice) {
                minPrice = product.productPrice
            }
        }

        if (userMoneyAmount <= minPrice || checkAllSoldout() == true) {
            returnChange()
            return true
        }

        return false
    }

    fun returnChange() {
        val returnCoins = mutableMapOf<Coin, Int>()
        for (coin in availableCoins) {
            while (availableCoins.getValue(coin.key) > 0 && userMoneyAmount >= coin.key.amount) {
                userMoneyAmount -= coin.key.amount
                availableCoins[coin.key] = availableCoins[coin.key]?.minus(1) ?: 0
                val count = returnCoins[coin.key] ?: 0
                returnCoins[coin.key] = count + 1
            }
        }
        OutputView.printCoins(returnCoins, "Change returned:")
        OutputView.printAmount(userMoneyAmount, "Unable to return:")
    }
}
