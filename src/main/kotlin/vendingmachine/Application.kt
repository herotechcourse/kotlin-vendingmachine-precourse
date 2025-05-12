package vendingmachine

fun main() {
	try {
		val vendingMachineHas = InputView.readAmountVendingMachine()
		val exchangedCoins = Coin.exchange(vendingMachineHas)
		OutputView.displayVendingMachineCoins(exchangedCoins)

		val products = InputView.readProducts()
		// TODO: if all products price bigger than amount -> handle

		val userMoney = InputView.readUserMoney()

		val vendingMachine = VendingMachine(exchangedCoins)


	} catch (e: IllegalArgumentException) {
		println("[ERROR]: ${e.message}")
	}

}
