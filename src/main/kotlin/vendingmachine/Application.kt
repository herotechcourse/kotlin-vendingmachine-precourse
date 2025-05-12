package vendingmachine

import view.InputView.getBalanceAmount
import view.InputView.getChangeInventory
import view.InputView.getProducts
import view.InputView.getPurchase
import view.OutputView.announceCoinsInVendingMachine
import view.OutputView.printChange
import view.OutputView.printUnableToReturn

fun main() {
    val vendingMachine = initializeVendingMachine()
    val products = getProducts()

    processPurchases(vendingMachine, products)
    processChange(vendingMachine)
}

fun initializeVendingMachine(): VendingMachine {
    val vendingMachine = VendingMachine(getChangeInventory())
    vendingMachine.getRandomCoins()
    announceCoinsInVendingMachine(vendingMachine)
    return vendingMachine
}

fun processPurchases(vendingMachine: VendingMachine, products: List<Product>) {
    vendingMachine.userBalance = getBalanceAmount()
    println("Inserted amount: ${vendingMachine.userBalance} KRW")

    executePurchase(getCheapestPrice(products), vendingMachine, products)
}

fun processChange(vendingMachine: VendingMachine) {
    val change = vendingMachine.calculateChange()
    printChange(change)
    printUnableToReturn(vendingMachine.userBalance)
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

// TODO: refactor, max 10 lines
fun executePurchase(minPrice: Int, vendingMachine: VendingMachine, products: List<Product>) {
    while (vendingMachine.userBalance >= minPrice) {
        val purchase = getPurchase()

        val product = getPurchaseFromProducts(products, purchase)
        if (product == null) {
            // TODO: throw error instead, catch error and re-prompt
            println("[ERROR] Product is not supported by vending machine.")
        } else {
            vendingMachine.userBalance -= product.price
            println("Inserted amount: ${vendingMachine.userBalance} KRW")
        }
    }
}
