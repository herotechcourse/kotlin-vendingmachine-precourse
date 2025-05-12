package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

object VendorMachineCoinsFactory {

    fun generateRandomCoins(amountHold: Int) : Map<Coin, Int> {
        var remaining = amountHold
        var coinsHold = mutableMapOf<Coin, Int>()

        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount
                val coin = when (amount) {
                    500 -> Coin.COIN_500
                    100 -> Coin.COIN_100
                    50 -> Coin.COIN_50
                    else -> Coin.COIN_10
                }

                coinsHold.put(coin, coinsHold.getOrDefault(coin, 0)+1)
            }
        }

        return coinsHold
    }

}