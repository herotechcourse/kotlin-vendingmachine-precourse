package vendingmachine

class OutputView {

    fun printHeader(message: String)
    {
        println()
        println(message)
    }
    fun printCoinsAvailable(items: List<Coins>)
    {
        for (item in items)
        {
            println("${item.valueOfCoin} KRW - ${item.numberOfCoins}")
        }
    }

    fun printMessage(message: String)
    {
        println(message)
    }
}