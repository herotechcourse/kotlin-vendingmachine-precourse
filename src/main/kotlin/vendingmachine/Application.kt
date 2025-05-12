package vendingmachine

fun main() {
	val vendingMachineHas = InputView.readAmountVendingMachine()
	val exchangedCoins = Coin.exchange(vendingMachineHas)
	OutputView.displayVendingMachineCoins(exchangedCoins)
}
