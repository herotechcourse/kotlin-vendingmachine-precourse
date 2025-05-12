package vendingmachine

fun main() {
    // TODO: Implement the program
    val vendingMachineAmount = InputValidator.getVendingMachineAmount()

    val coins = Coin.calculate(vendingMachineAmount)
    println(coins)

    val products = InputValidator.getValidProducts()
    println(products)

    val vendingMachine = VendingMachine()
    vendingMachine.start()
}
