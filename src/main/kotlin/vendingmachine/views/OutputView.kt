package vendingmachine.views

class OutputView {
	fun printBalance(balance: Int) {
		println("Inserted amount: $balance KRW")
	}

	fun printChange(change: HashMap<Int, Int>) {
		for (key in change.keys) {
			println("$key KRW - ${change[key]}")
		}
	}
}