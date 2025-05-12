package vendingmachine

object OutputView {

	fun displayVendingMachineCoins(exchangedCoins: List<ExchangedCoin>) {
		println(SHOW_COINS_IN_VENDING_MACHINE)
		val output = mutableMapOf<String, String>()

		exchangedCoins.forEach {
			when (it.coin) {
				Coin.COIN_500 -> output.put("500 KRW", "${it.count}")
				Coin.COIN_100 -> output.put("100 KRW", "${it.count}")
				Coin.COIN_50 -> output.put("50 KRW", "${it.count}")
				Coin.COIN_10 -> output.put("10 KRW", "${it.count}")
			}
		}
		printVendingMachine(output, "500 KRW")
		printVendingMachine(output, "100 KRW")
		printVendingMachine(output, "50 KRW")
		printVendingMachine(output, "10 KRW")
	}

	fun displayResults(exchangedCoins: List<ExchangedCoin>) {
		println(SHOW_RESULT_HEADER)
		val output = mutableMapOf<String, String>()
		exchangedCoins.forEach {
			when (it.coin) {
				Coin.COIN_500 -> output.put("500 KRW", "${it.count}")
				Coin.COIN_100 -> output.put("100 KRW", "${it.count}")
				Coin.COIN_50 -> output.put("50 KRW", "${it.count}")
				Coin.COIN_10 -> output.put("10 KRW", "${it.count}")
			}
		}
		printVendingMachine(output, "500 KRW")
		printVendingMachine(output, "100 KRW")
		printVendingMachine(output, "50 KRW")
		printVendingMachine(output, "10 KRW")

	}

	private fun printVendingMachine(output: Map<String, String>, target: String) {
		val found = output[target]
		if (found != null)
			println("$target - $found")
		else
			println("$target - 0")
	}
}