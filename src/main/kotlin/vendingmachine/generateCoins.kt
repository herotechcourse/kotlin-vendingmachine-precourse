package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

class CoinMachine() {


    fun generateCoins(amount: Int): List<Int> {
        var listOfCoins = arrayListOf<Int>()
        var remaining = amount
        while (remaining >= 10) {
            var amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))

            if (remaining >= amount) {
                listOfCoins.add(amount)
                remaining -= amount
            }
        }
        return listOfCoins
    }

    fun countNumberOfCoins(machineCoins:List<Int>):List<Int>{

        var num500 = 0
        var num100 = 0
        var num50 = 0
        var num10 = 0
        var coinsCount = arrayListOf<Int>()

        for(coin in machineCoins){
            var coinsCount = arrayListOf<Int>()
            if (coin == 500)num500 += 1
            else if (coin == 100)num100 += 1
            else if(coin == 50) num50 += 1
            else {
                num10 += 1
            }
        }
        coinsCount.add(num500)
        coinsCount.add(num100)
        coinsCount.add(num50)
        coinsCount.add(num10)

        

    }

}