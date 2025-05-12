package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

object CoinGenerator {

    fun generateCoin(readInput: Int) {
        var remaining = readInput
        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount
            }
            amount
        }
    }
}