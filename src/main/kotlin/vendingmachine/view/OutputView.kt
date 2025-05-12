package vendingmachine.view

import vendingmachine.view.InputView

/*
Coins in the vending machine:
500 KRW - 0
100 KRW - 3
50 KRW - 1
10 KRW - 10



 */
class OutputView {

    fun displayError(message: String?) {
        println(message)
    }

    fun displayBalanceCoin(balance: List<Int>) {
        println("\nCoins in the vending machine:")
        println("500 KRW - ${balance[0]}")
        println("100 KRW - ${balance[1]}")
        println("50 KRW - ${balance[2]}")
        println("10 KRW - ${balance[3]}")
    }

}