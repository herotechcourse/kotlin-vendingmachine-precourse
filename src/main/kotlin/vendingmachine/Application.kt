package vendingmachine

fun main() {
    // TODO: Implement the program
    val holds = vendingmachine.InputView.amountMachineHolds()
    //val amount = vendingmachine.InputView.amountInsert()
    OutputView.displayHolds()
    val nameProduct = vendingmachine.InputView.enterTheNameOfTheProduct()
}
