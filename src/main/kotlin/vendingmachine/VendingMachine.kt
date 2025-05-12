package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class VendingMachine {
    var coinsList = mutableListOf<Int>()
    fun generateCoin(availableAmount: Int): List<Int> {
        var remaining = availableAmount
        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount
                this.coinsList.add(amount)
            }
        }
        return countCoins(this.coinsList)
    }

    private fun countCoins(coinsList: MutableList<Int>): List<Int>{
        val count500 = this.coinsList.count{it == 500}
        val count100 = this.coinsList.count{it == 100}
        val count50 = this.coinsList.count{it == 50}
        val count10 = this.coinsList.count{it == 10}

        return listOf(count500, count100, count50, count10)
    }

}
