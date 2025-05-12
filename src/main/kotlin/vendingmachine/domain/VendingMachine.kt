package vendingmachine.domain

import vendingmachine.Coin
import camp.nextstep.edu.missionutils.Randoms

class VendingMachine(private var inputAmount: Int) {
    private val Coins = mutableMapOf<Coin, Int>()

    init {
        Coins[Coin.COIN_500] = 0
        Coins[Coin.COIN_100] = 0
        Coins[Coin.COIN_50] = 0
        Coins[Coin.COIN_10] = 0
        initCoins()
    }

    fun getCoins() = Coins.toMap()

    private fun initCoins() {
        var tmp = inputAmount
        while (tmp != 0) {
            val coins = Coin.getCoins()
            val randomCoins = Randoms.pickNumberInList(coins)
            if (randomCoins <= tmp) {
                tmp -= randomCoins
                this.Coins[Coin.getCoinEnum(randomCoins)] = this.Coins[Coin.getCoinEnum(randomCoins)]!! + 1
            }
        }
    }
}