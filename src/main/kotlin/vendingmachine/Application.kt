package vendingmachine

import view.InputView.getBalanceAmount
import view.InputView.getChangeInventory
import view.InputView.getProducts
import view.InputView.getPurchase
import view.OutputView

fun main() {
    // TODO: Implement the program

    val changeInventory = getChangeInventory()

    val vendingMachine = VendingMachine(changeInventory)
    vendingMachine.getRandomCoins()

    OutputView.announceCoinsInVendingMachine()
    OutputView.printNumberOfCoin(500, vendingMachine.numberOf500Coin)
    OutputView.printNumberOfCoin(100, vendingMachine.numberOf100Coin)
    OutputView.printNumberOfCoin(50, vendingMachine.numberOf50Coin)
    OutputView.printNumberOfCoin(10, vendingMachine.numberOf10Coin)

    val products = getProducts()

    vendingMachine.userBalance = getBalanceAmount()
    println("Inserted amount: ${vendingMachine.userBalance} KRW")


    val minPrice = getCheapestPrice(products)
    executePurchase(minPrice, vendingMachine, products)

}

fun getPurchaseFromProducts(products: List<Product>, purchase: String): Product? {
    for (product in products) {
        if (product.name == purchase)
            return product
    }
    return null
}

fun getCheapestPrice(products: List<Product>): Int {
    var min = products[0].price
    for (product in products) {
        if (product.price < min)
            min = product.price
    }
    return min
}

fun executePurchase(minPrice: Int, vendingMachine: VendingMachine, products: List<Product>) {
    while (vendingMachine.userBalance >= minPrice) {
        val purchase = getPurchase()

        val product = getPurchaseFromProducts(products, purchase)
        if (product == null) {
            // TODO: throw error instead, catch and re-prompt
            println("[ERROR] Product is not supported by vending machine.")
        } else {
            vendingMachine.userBalance -= product.price
            if (vendingMachine.userBalance >= minPrice) {
                println("Inserted amount: ${vendingMachine.userBalance} KRW")
            }
        }
    }
}
