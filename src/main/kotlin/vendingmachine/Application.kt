package vendingmachine

import vendingmachine.service.VendingMachineSetting



fun main() {
    // TODO: Implement the program

    try {
        VendingMachineSetting.run()
    } catch (e: IllegalArgumentException) {
        throw e
    }


}
