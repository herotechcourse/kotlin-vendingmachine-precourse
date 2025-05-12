package vendingmachine

class CoinRepository(val amount: Int, ) {
	val coins: HashMap<Int, Int> = hashMapOf(
		10 to 0,
		50 to 0,
		100 to 0,
		500 to 0
	)

	init {
		require(amount >= 0) {
			"[ERROR] Amount must be at least zero."
		}
		require(amount % Config.MIN_COIN == 0) {
			"[ERROR] Purchase amount must be a positive multiple of ${Config.MIN_COIN}."
		}
		generateCoins()
	}

	fun generateCoins() {
		var remaining: Int = amount
		while (remaining >= Config.MIN_COIN) {
			if (remaining == Config.MIN_COIN) {
				coins[Config.MIN_COIN] = coins[Config.MIN_COIN]!! + 1
				remaining -= Config.MIN_COIN
			}
			val randomCoin = Coin.randomCoinValue()
			if (remaining >= randomCoin) {
				coins[randomCoin] = coins[randomCoin]!! + 1
				remaining -= randomCoin
			}
		}
	}

	fun getBalance(): Int {
		return coins.keys.sumOf { coinValue ->
			coinValue * coins[coinValue]!!
		}
	}
}