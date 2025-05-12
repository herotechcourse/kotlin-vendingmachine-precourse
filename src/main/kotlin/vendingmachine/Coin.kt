package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    companion object {
        fun randomCoinValue(): Int {
            val coinList = Coin.entries.map { it.amount }
            return Randoms.pickNumberInList(coinList)
        }
    }
}
