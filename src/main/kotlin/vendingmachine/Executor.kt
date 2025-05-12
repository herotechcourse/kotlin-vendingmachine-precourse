package vendingmachine

class Executor() {
    fun run() {
        val machine = createMachine()
        readInventory(machine)
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

    private fun readInventory(machine: VendingMachine) {
        while (true) {
            try {
                val inventory = InputView.getInventory()
                parseInventory(inventory, machine)
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun parseInventory(inventory: List<List<String>>, machine: VendingMachine) {
        for (elem in inventory) {
            val productName = elem[0]
            val price = elem[1].toIntOrNull() ?: throw IllegalArgumentException("[ERROR]: int required")
            val quantity = elem[2].toIntOrNull() ?: throw IllegalArgumentException("[ERROR]: int required")
            val product = Product(productName, price, quantity)
            machine.addProduct(product)
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
        while (true) {
            try {
                InputView.getProductName()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    companion object {
        private const val MAX_RETRY = 5
    }
}