package vendingmachine

import vendingmachine.domain.VendingMachine
import vendingmachine.domain.Product
import vendingmachine.domain.MachineProduct

import vendingmachine.view.InputView
import vendingmachine.view.OutputView

import vendingmachine.controller.MachineController

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

    // (3) Accept product
    OutputView.output4()
    // Init Product
    MachineController.startMachine()

    // (4) Check Price from user
//    OutputView.output5()

//    OutputView.output6()
//
//    OutputView.output7()
//    InputView.input7()
//
//    OutputView.output8()
//    OutputView.output9()
}