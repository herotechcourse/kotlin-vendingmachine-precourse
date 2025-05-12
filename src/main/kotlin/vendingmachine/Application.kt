package vendingmachine

import view.InputView.getChangeInventory
import view.InputView.getProducts
import view.OutputView

fun main() {
    // TODO: Implement the program

    val changeInventory = getChangeInventory()
//    println(changeInventory)

    val vendingMachine = VendingMachine(changeInventory)
    vendingMachine.getRandomCoins()
//    println()
//    println(vendingMachine.numberOf500Coin)
//    println(vendingMachine.numberOf100Coin)
//    println(vendingMachine.numberOf50Coin)
//    println(vendingMachine.numberOf10Coin)
//    println()
//    println(vendingMachine.changeInventory)
    OutputView.announceCoinsInVendingMachine()
    OutputView.printNumberOfCoin(500, vendingMachine.numberOf500Coin)
    OutputView.printNumberOfCoin(100, vendingMachine.numberOf100Coin)
    OutputView.printNumberOfCoin(50, vendingMachine.numberOf50Coin)
    OutputView.printNumberOfCoin(10, vendingMachine.numberOf10Coin)

    val products = getProducts()
//    println(products)
}
