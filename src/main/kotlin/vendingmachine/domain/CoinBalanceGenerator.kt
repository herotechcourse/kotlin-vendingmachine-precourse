package vendingmachine.domain

import camp.nextstep.edu.missionutils.Randoms

class CoinBalanceGenerator(var sum: Int, var balance: MutableList<Int>) {

    fun generateCoinBalance(): MutableList<Int> {
        var updatedCoinIndex: Int
        var updatedCoinValue: Int

        while (sum >= 10) {
            updatedCoinIndex = getUpdatedCoinIndex(sum, balance)
            balance[updatedCoinIndex] += 1
            updatedCoinValue = convertIndexToValue(updatedCoinIndex)
            sum -= updatedCoinValue
        }
        return balance
    }

    fun getUpdatedCoinIndex(currentSum: Int, balance: MutableList<Int>): Int {
        var index: Int = 1

        if (currentSum >= 500) {
            index = Randoms.pickNumberInList(listOf(0, 1, 2, 3))
        } else if (currentSum >= 100) {
            index = Randoms.pickNumberInList(listOf(1, 2, 3))
        } else if (currentSum >= 50) {
            index = Randoms.pickNumberInList(listOf(2, 3))
        }
        return index
    }

    private fun convertIndexToValue(typeIndex: Int): Int{
        var actualValue: Int = 10
        when (typeIndex) {
            0 -> {
                actualValue = 500
            }
            1 -> {
                actualValue = 100
            }
            2 -> {
                actualValue = 50
            }
        }
        return actualValue
    }

    fun generateCoins() {
        var updatedCoinIndex: Int
        var updatedCoinValue: Int

        while (sum >= 10) {
            updatedCoinIndex = getUpdatedCoinIndex(sum, balance)
            balance[updatedCoinIndex] += 1
            updatedCoinValue = convertIndexToValue(updatedCoinIndex)
            sum -= updatedCoinValue
        }
    }
}