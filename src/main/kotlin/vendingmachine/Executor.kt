package vendingmachine

class Executor() {
    fun run() {
        InputView.getInitialAmount()
        InputView.getInventory()
        InputView.getPurchaseAmount()
        InputView.getProductName()
    }
}