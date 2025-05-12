package vendingmachine

fun main() {
    val machine = VendingMachine(InputView.handleInitialAmountInput())
    machine.runMachine()
}
