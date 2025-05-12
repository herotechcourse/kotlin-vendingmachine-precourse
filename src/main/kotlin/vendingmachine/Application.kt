package vendingmachine

import vendingmachine.domain.VendingMachine
import vendingmachine.view.InputView
import vendingmachine.view.OutputView

fun main() {
    // (1) Init vending machine with given money from User
    OutputView.output1()
    var holdAmount = InputView.input1().toInt()

    // (2) Generate random combination of coins in vending machine
    // Init Machine Coin
    var machineCoins = VendingMachine(holdAmount)

    // Print Machine Coin
    OutputView.output2()
    OutputView.output3(machineCoins.getCoins())

//

//
//    OutputView.output4()
//    InputView.input4()
//
//    OutputView.output5()
//    InputView.input5()
//
//    OutputView.output6()
//
//    OutputView.output7()
//    InputView.input7()
//
//    OutputView.output8()
//    OutputView.output9()
}