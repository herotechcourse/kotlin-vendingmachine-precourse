package vendingmachine

class OutputView {
    companion object {
        fun printCoins(coinMap: Map<Coin, Int>, message: String) {
            println(message)

            for (coin in coinMap.toSortedMap()) {
                println("${Coin.printCoin(coin.key)} - ${coin.value} ")
            }
        }

        fun printAmount(amount: Int, message: String) {
            println("$message: $amount KRW")
        }

        fun primaryCoinPrint(coinMap: Map<Coin, Int>) {
            println("Coins in the vending machine:")

            Coin.entries.forEach { coins ->
                var amount = coinMap[coins]
                if (coins !in coinMap) {
                    amount = 0
                }
                if (coins != Coin.NONE) {
                    println("${Coin.printCoin(coins)} - $amount")
                }
            }
        }

    }
}