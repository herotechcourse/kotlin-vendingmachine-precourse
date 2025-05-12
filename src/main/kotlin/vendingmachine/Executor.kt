package vendingmachine

class Executor() {
    fun run() {
        createMachine()
        InputView.getInventory()
        InputView.getPurchaseAmount()
        InputView.getProductName()
    }

    private fun createMachine() {
        while (true) {
            try {
                val amount = InputView.getInitialAmount()
                val vendingMachine = VendingMachine(amount)
                OutputView.displayCoins(vendingMachine.coins)
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    companion object {
        private const val MAX_RETRY = 5
    }
}