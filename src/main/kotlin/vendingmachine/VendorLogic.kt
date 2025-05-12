package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class VendorLogic {

    fun generateCoins(): Int {
        val coinsList = mutableListOf(500, 100, 50, 10)
        val generateCoin = Randoms.pickNumberInList(coinsList)
        return generateCoin
    }

    fun generateListOfCoins(amount: Int): MutableList<Int> {
        val coinsList = mutableListOf<Int>()
        var count = 0
        do {
            val coin = generateCoins()
            coinsList.add(coin)
            count += coin

        } while (count != amount)
        println("count: $count")
        println("coinsList: $coinsList")

        return coinsList
    }

    fun generateListOfProducts(productDescription: MutableList<String>):
            MutableList<MutableList<String>> {
        val listOfProducts = mutableListOf<MutableList<String>>()
        listOfProducts.add(productDescription)
        return listOfProducts
    }
}