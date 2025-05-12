package vendingmachine.service

import vendingmachine.view.InputView
import vendingmachine.view.OutputView
import vendingmachine.domain.Product
import vendingmachine.domain.machineProducts

object VendingMachineSetting {

    fun run() {
        val amount = InputView.readCoinAmount()
        println(amount)

        //Generate the Coins for exchange
        val machine = VendingMachine(amount)
        val coins = machine.generateCoinsVendingMachine(amount)
        OutputView.coinsVendingMachine(coins)

        //Next Adding products for the vending machine
        val products = InputView.readProducts()
        val productsInserted = machineProducts.generateProducts(products)

        // Please enter the amount of money:
        val amountCustomer = InputView.readAmountOfMoneyInserted()

        //while (amountCustomer )
        //output Inserted amount: 3000 KRW
        OutputView.currentlyAmount(amountCustomer)

        //Please enter the name of the product to purchase:
        InputView.buyProduct()

        // output example Cola

        //output Inserted amount: 1500 KRW


        // If the remaining balance is less than the price of the
        // cheapest available product, or if all products are sold out, the machine immediately returns change.

        // If the machine cannot return the full amount in change, it returns as much as it can, using available coins.


    }
}