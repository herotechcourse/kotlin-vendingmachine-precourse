package vendingmachine

fun main() {
	try {
		val vendingMachineHas = InputView.readAmountVendingMachine()
		val exchangedCoins = Coin.exchange(vendingMachineHas)
		OutputView.displayVendingMachineCoins(exchangedCoins)

		val products = InputView.readProducts()

		val userMoney = InputView.readUserMoney()
		val vendingMachine = VendingMachine(exchangedCoins, products, userMoney)
		vendingMachine.run()


	} catch (e: IllegalArgumentException) {
		println("[ERROR]: ${e.message}")
	}

}
