package vendingmachine

object OutputView {
    fun showHoldingCoins(machine: Machine) {
        machine.coinBoard.forEach { coin, count ->
            machine.getCoinInfo(coin)
        }
    }
}