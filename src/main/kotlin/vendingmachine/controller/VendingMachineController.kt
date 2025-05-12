package vendingmachine.controller

import vendingmachine.view.InputView
import vendingmachine.view.OutputView
import vendingmachine.Coin
import vendingmachine.model.Product

import camp.nextstep.edu.missionutils.Randoms

class VendingMachineController {
    fun run() {
        val change = getInitialChange()
        val coinsInVendingMachine = getChangeCoins(change)
        
        val products = getProducts()

        var totalAmount = getInitialAmount()
        OutputView().displayCoinChanges(coinsInVendingMachine)
        OutputView().displayProducts(products)
    }

    fun getInitialChange(): Int {
        val change = InputView.enterInitialChange()
        return change
    }


    fun getInitialAmount(): Int {
        val initialAmount = InputView.enterInitialAmount()
        return initialAmount
    }

    fun getChangeCoins(change: Int): MutableList<Coin>{
        val coins = mutableListOf<Coin>()
        var remaining = change

        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount
                coins.add(Coin.from(amount))
            }
        }
        return coins
    }

    fun getProducts(): List<Product> {
        val products = mutableListOf<Product>()

        val productInputs = InputView.enterProducts()

        productInputs.forEach {
            val product = parseProduct( it )
            products.add(product)
        }
        
        return products.toList()
    }

    fun parseProduct(input: String): Product {
        val productInfo = input.removeSurrounding("[", "]").split(",").map { it.trim() }

        // require(products.distinct().size == products.size) { "Member products must be unique." }
        // require(products.all { it.matches(Regex("^[A-Za-z_]{1,5}$")) }) { 
        //     "Member products must contain only letters or underscores and be 1 to 5 characters long." 
        // }

        val productName = productInfo[0]
        val productCost = productInfo[1].toInt()
        val productQuantities = productInfo[2].toInt()
        
        val product = Product( productName, productCost, productQuantities )

        return product;
    }
}