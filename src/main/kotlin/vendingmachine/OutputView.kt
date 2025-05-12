package vendingmachine

object OutputView {
    fun showHoldingCoins(machine: Machine) {
        machine.coinBoard.forEach { coin, count ->
            if (coin != Coin.NONE) { println(machine.getCoinInfo(coin)) }
        }
    }
}