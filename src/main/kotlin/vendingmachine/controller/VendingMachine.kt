package vendingmachine.controller

import vendingmachine.model.CoinsGenerator
import vendingmachine.model.Product
import vendingmachine.view.InputView
import vendingmachine.view.OutputView

class VendingMachine {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var balance = 0
    private var purchaseAmount = 0

    fun run() {
        this.balance = inputView.inputMachineBalance()

        val coinsGenerator = CoinsGenerator(balance)
        val machineBalance = coinsGenerator.createCoins()
        //println(machineBalance.map { "${it.key}: ${it.value}" }.joinToString(", "))
        val products = inputView.inputProduct()
        //println(products[0].name + " "+ products[0].price +" " + products[0].quantity )
        purchaseAmount = inputView.inputPurchaseAmount()

        purchaseProduct(products)

    }

    fun purchaseProduct(products: MutableList<Product>) {
        val cheapestProduct: Int = products.minOf { it.price }

        while (purchaseAmount > cheapestProduct) {
            outputView.displayInsertedAmount(purchaseAmount)
            val productName = inputView.inputPurchaseProduct()
            val product: List<Product> = products.filter { it.name == productName }
            if (product[0].quantity == 0)
                return
            this.purchaseAmount -= product[0].price
            product[0].quantity--
        }
    }

}