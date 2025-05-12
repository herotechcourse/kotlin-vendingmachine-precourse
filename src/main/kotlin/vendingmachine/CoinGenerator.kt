package vendingmachine

import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf

class CoinGenerator {

    fun calculateNumberOfCoins(coinAmountEntered: Int): List<Coins>
    {
        val outputView = OutputView()
        var remainingAmount = coinAmountEntered
        var coin: Coin
        var coinsAvailable = mutableListOf<Coins>()
        var coinsUpdated = listOf<Coins>()
        var coinWithNumber: Coins
        while (remainingAmount >= 10) {
            val coinValue = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remainingAmount >= coinValue) {
                remainingAmount -= coinValue
                coin = determineCoinValue(coinValue)
                //coinWithNumber = calculateNumberOfEachCoin(coin)

//                coinsUpdated = checkIfCoinIsInTheList(coinWithNumber, coinsAvailable)
//                outputView.printCoinsAvailable(coinsUpdated)
                coinsAvailable.add(calculateNumberOfEachCoin(coin))
                outputView.printCoinsAvailable(coinsAvailable)
            }
        }
        return coinsAvailable
    }

    fun calculateNumberOfEachCoin(valuePicked : Coin): Coins
    {
        var numberOfCoins = 0;
        var coinAndNumber: Coins
        if (valuePicked == Coin.COIN_10 || valuePicked == Coin.COIN_50 || valuePicked == Coin.COIN_100 || valuePicked == Coin.COIN_500)
        {
            numberOfCoins++

        }
        coinAndNumber = Coins(valuePicked, numberOfCoins)
        return coinAndNumber
    }

    fun determineCoinValue(valuePicked: Int): Coin {
        if (valuePicked == 10) { return Coin.COIN_10 }
        if (valuePicked == 50) { return Coin.COIN_50 }
        if (valuePicked == 100) { return Coin.COIN_100 }
        //if (valuePicked == 500) { return Coin.COIN_500}
        else
            return Coin.COIN_500
    }

    fun checkIfCoinIsInTheList(coin: Coins, coinList: MutableList<Coins>): List<Coins>
    {
        var coinsUpdated = coinList

        for (item in coinsUpdated)
        {
            if (coin.valueOfCoin == item.valueOfCoin)
            {
                item.numberOfCoins++
            }
            if (coin.valueOfCoin != item.valueOfCoin){
            coinsUpdated.add(coin)
            }
        }
        return coinsUpdated
    }
}