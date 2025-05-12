package vendingmachine

class Executor() {
    fun run() {

        while (true) {
            try {
                val amount = InputView.getInitialAmount()
                val vendingMachine = VendingMachine(amount)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        InputView.getInventory()
        InputView.getPurchaseAmount()
        InputView.getProductName()
    }
}