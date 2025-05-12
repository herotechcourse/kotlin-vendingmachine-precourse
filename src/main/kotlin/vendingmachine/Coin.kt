package vendingmachine

data class ExchangedCoin(val coin: Coin, val count: Int, val remaining: Int) {
    fun sum():Int {
        val coinType = when (coin) {
	        Coin.COIN_500 -> 500
	        Coin.COIN_100 -> 100
	        Coin.COIN_50 -> 50
	        Coin.COIN_10 -> 10
        }
        return coinType * count
    }
}

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    companion object {

        fun exchange(amount: Int): List<ExchangedCoin> {
            val exchanged = mutableListOf<ExchangedCoin>()
            exchanged.add(exchangeEach(amount))
            while (exchanged.last().remaining > 10 || exchanged.last().remaining != 0) {
               exchanged.add(exchangeEach(exchanged.last().remaining))
            }
            return (exchanged)
        }

        private fun exchangeEach(amount: Int): ExchangedCoin {

            val type = when {
                amount >= COIN_500.amount -> COIN_500
                amount >= COIN_100.amount -> COIN_100
                amount >= COIN_50.amount -> COIN_50
                amount >= COIN_10.amount -> COIN_10
                else -> throw IllegalArgumentException("coin should be in 500 .. 10")
            }

            return when (type) {
	            COIN_500 -> initEachCoinType(Coin.COIN_500, amount)
	            COIN_100 -> initEachCoinType(Coin.COIN_100, amount)
	            COIN_50 -> initEachCoinType(Coin.COIN_50, amount)
	            COIN_10 -> initEachCoinType(Coin.COIN_10, amount)
            }
        }

        private fun initEachCoinType(coin: Coin, amount: Int): ExchangedCoin {
            val count = amount / coin.amount
            return ExchangedCoin(coin, count , amount - (coin.amount * count))
        }
    }
}
