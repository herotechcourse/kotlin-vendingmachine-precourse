package vendingmachine

import vendingmachine.view.Messages
import vendingmachine.view.OutputView
import vendingmachine.view.InputView
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin
import javax.swing.Painter


fun main() {
    OutputView.askUser(Messages.ASK_MONEY)
    var machineBudget = InputView.getMachineBudget(Console.readLine())
    OutputView.askUser(Messages.GENERATED_COINS)

    val coinList: List<Int> = Coin.entries.map { it.amount }
    println(coinList)
    val coinTable = mutableMapOf<Coin, Pair<Int, Int>>()
    for (coin in Coin.entries) {
        coinTable[coin] = Pair(0, coin.amount)
    }
        println(coinTable)
    println(Coin.COIN_10.amount)
    while(machineBudget > coinList.minOf { it }) {
        val randomCoin = Randoms.pickNumberInList(coinList)
        machineBudget -= randomCoin
        println(machineBudget)
        println(randomCoin)
        /*
        TODO: I would have then assigned the randomly generated number from list to its correspondent
        list type, then in the outputview I woudl have printed the cointTable showing the list
        of generated coins based on the subtraction from machineBudget.
        Unfortunately while I had some very good ideas on how I would set all of this up I felt very discouraged as
        i just learned kotlin in the last 2 weeks and my mind does not immediately goes into what is possible with it
        unless suggested (doing a project via documentation and internet alone, in only 5 hours really felt impossible for me and was not expecting the project to be this big)
        * */
    }
}
