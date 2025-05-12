package vendingmachine

import vendingmachine.view.InputView
import vendingmachine.view.OutputView

fun main() {

    val inputView = InputView()
    val vm = VendingMachine()
    val outputView = OutputView()

    outputView.printCoinsAvailable(vm.generateCoin(inputView.getVMAmount()))


}
