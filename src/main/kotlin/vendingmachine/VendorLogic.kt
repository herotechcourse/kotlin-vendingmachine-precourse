package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class VendorLogic {

    fun generateCoins(coinsList: List<Int>): Int {
        val generateCoin = Randoms.pickNumberInList(coinsList)
        return generateCoin
    }

    fun generateListOfCoins(amount: Int): MutableList<Int> {
        val coins = listOf<Int>( 500, 100, 50, 10 )
        val coinsList = mutableListOf<Int>()
        var count = 0

        for (item in coins) {
            if (count != amount) {
                while (true) {
                    val coin = generateCoins(coins)
                    val sum = count + coin
                    if (sum > amount) {
                        val rest = amount - count
                        val coinsRestList = coins.filter{it <= rest}
                        val coinsRest = generateCoins(coinsRestList)
                        count += coinsRest
                    } else {
                        coinsList.add(coin)
                        count += coin
                        println("count: $count")
                    }
                }
            } else {
                break
            }
        }

        println("coinsList: $coinsList")
        return coinsList
    }

    fun generateListOfProducts(name: String, price: String, quantity: String): MutableList<String> {
        val listOfProducts = mutableListOf<String>()
        listOfProducts.add(name)
        listOfProducts.add(price)
        listOfProducts.add(quantity)
        return listOfProducts
    }
}