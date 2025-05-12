package vendingmachine

object OutputView {
    fun showHoldingCoins(machine: Machine) {
        println("\nCoins in the vending machine:")
        machine.coinBoard.forEach { coin, count ->
            if (coin != Coin.NONE) { println(machine.getCoinInfo(coin)) }
        }
    }
}