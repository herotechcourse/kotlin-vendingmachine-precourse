package vendingmachine

class Executor() {
    fun run() {
        val machine = createMachine()
        //readInventory()
        readPurchaseAmount(machine)
        purchase(machine)
    }

    private fun createMachine(): VendingMachine {
        while (true) {
            try {
                val amount = InputView.getInitialAmount()
                val vendingMachine = VendingMachine(amount)
                OutputView.displayCoins(vendingMachine.coins)
                return vendingMachine
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readInventory() {
        while (true) {
            try {
                InputView.getInventory()
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readPurchaseAmount(machine: VendingMachine) {
        while (true) {
            try {
                machine.initBudget(InputView.getPurchaseAmount())
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun purchase(machine: VendingMachine) {
        OutputView.displayInsertedAmount(machine.budget)
        InputView.getProductName()
    }

    companion object {
        private const val MAX_RETRY = 5
    }
}