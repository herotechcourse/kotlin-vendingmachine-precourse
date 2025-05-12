package vendingmachine.service

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin

object CoinsGeneratorService {
   private val validCoins = listOf(500, 100, 50, 10)

    fun generateWith(InputAmount: Int): MutableList<Coin> {
        var remaining = InputAmount
        val coins = mutableListOf<Coin>()
        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(validCoins)
            if (remaining >= amount) {
                remaining -= amount
                val coin = Coin.from(amount)
                coins += coin
            }
        }
        return coins
    }
}