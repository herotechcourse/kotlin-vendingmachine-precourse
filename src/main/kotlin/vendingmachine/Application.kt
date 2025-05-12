package vendingmachine

import vendingmachine.domain.VendingMachine
import vendingmachine.domain.Product

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

    // (3) Accept product
    OutputView.output4()
    // Init Product
    val productList = mutableMapOf<String, Product>()
    var machineProducts = InputView.input4()
    val previousProducts = machineProducts.split(";")
    for (previousProduct in previousProducts) {
        val removedBracket = previousProduct.removeSurrounding("[", "]")
        val feature = removedBracket.split(",")
        val name = feature[0]
        productList[name] = Product(feature)
    }
    println(previousProducts)




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