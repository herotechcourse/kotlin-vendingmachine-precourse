package vendingmachine.controller

import vendingmachine.view.InputView
import vendingmachine.view.OutputView

class VendingMachineController {
    fun run() {
        val change = getInitialChange()
        OutputView().displayInt(change)
    }

    fun getInitialChange(): Int {
        val change = InputView.enterInitialChange()
        return change
    }
}