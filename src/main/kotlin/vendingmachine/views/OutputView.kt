package vendingmachine.views

class OutputView {
	fun printBalance(balance: Int) {
		println("Inserted amount: $balance KRW")
	}

	fun printCoinsInVendingMachine(coins: HashMap<Int, Int>) {
		for (key in coins.keys) {
			println("$key KRW - ${coins[key]}")
		}
	}

	fun printChange(change: HashMap<Int, Int>) {
		for (key in change.keys) {
			println("$key KRW - ${change[key]}")
		}
	}

	fun printUnableReturn(balance: Int) {
		println("Unable to return: $balance KRW")
	}
}