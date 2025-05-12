package vendingmachine

import vendingmachine.views.InputView
import vendingmachine.views.OutputView

fun main() {
	val inputView = InputView()
	val outputView = OutputView()

	val coinSum = runUntilValid { inputView.readCoinSum()}
	val coinRepository = CoinRepository(coinSum)

	println()

	outputView.printCoinsInVendingMachine(coinRepository.coins)

	println()

	val products = runUntilValid { inputView.readProductInventory() }
	val productInventory = ProductInventory()
	for (p in products) productInventory.registerProduct(p)

	println()

	val balance = runUntilValid { inputView.readPurchaseAmount() }
	val purchaseModule = PurchaseModule(productInventory, coinRepository, balance)

	println()

	while (purchaseModule.purchasePossible()) {
		outputView.printBalance(purchaseModule.balance)
		val item = inputView.readItem()
		purchaseModule.purchaseItem(item)
		println()
	}

	val change = purchaseModule.processChange()

	outputView.printBalance(purchaseModule.balance)
	outputView.printChange(change)

	println()

	outputView.printUnableReturn(purchaseModule.balance)

}

private inline fun <T> runUntilValid(block: () -> T): T {
	while (true) {
		try {
			return block()
		} catch (e: Exception) {
			println(e.message)
		}
	}
}