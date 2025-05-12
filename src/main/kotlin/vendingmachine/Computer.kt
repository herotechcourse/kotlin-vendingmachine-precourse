package vendingmachine

class Computer {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val machine = VendingMachine()

    fun run(){
        machine.balance = inputView.getBalance()
        outputView.displayCoins(machine.getCoinsHeld())

        machine.products = inputView.getProducts()
        machine.balance += inputView.getMoney()

        runSales(machine)
        outputView.returnChange(machine.returnChange(), machine.balance)
    }

    private fun runSales(machine: VendingMachine) {
        while(true){
            outputView.printBalance()
            val sold = inputView.sell()
            try {
                processPurchase(sold)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
            if (!machine.canPurchase())
                break
        }
    }

    private fun processPurchase(item: String) {
        val product = machine.getProduct(item)
        if (product.quantity <= 0)
            throw IllegalArgumentException("[ERROR] Product is sold out!")
        if (product.price > machine.balance)
            throw IllegalArgumentException("[ERROR] Funds are insufficient for this purchase!")
            machine.balance -= product.price
    }
}