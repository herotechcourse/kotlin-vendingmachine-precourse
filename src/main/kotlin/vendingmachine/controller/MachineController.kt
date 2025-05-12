package vendingmachine.controller

import vendingmachine.VendingMachine
import vendingmachine.domen.RandomCoinsGenerator
import vendingmachine.view.InputView

class MachineController(
    private val vending : VendingMachine = VendingMachine(



) ) {

    fun run() {
        println(" ***** Welcome *******")
    }


}
