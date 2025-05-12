package vendingmachine

fun main() {
    val machine = VendingMachine(InputView.handleInitialAmount())
    machine.runMachine()
}
