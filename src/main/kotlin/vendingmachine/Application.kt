package vendingmachine

fun main() {
    // TODO: Implement the program
    val vendingMachineAmount = InputValidator.getVendingMachineAmount()

    val coins = Coin.calculate(vendingMachineAmount)
    println(coins)

    val vendingMachine = VendingMachine()
    vendingMachine.start()
}
