package vendingmachine.controller

import vendingmachine.view.InputView
import vendingmachine.view.OutputView
import vendingmachine.util.Change
import vendingmachine.Coin
import vendingmachine.model.Product

import camp.nextstep.edu.missionutils.Randoms

class VendingMachineController {
    fun run() {
        val change = getInitialChange()
        val coinsInVendingMachine = getChangeCoins(change)
        OutputView().displayInitialCoins(coinsInVendingMachine)
        
        val products = getProducts()
        val minimumCost = getMinimumCost(products)

        val totalInitialAmount = getInitialAmount()
        val remainder = generateVendingMachine(products, totalInitialAmount, minimumCost)

        val finalChange = returnChange(remainder, coinsInVendingMachine)

        val unreturnedAmount = getUnreturnedAmount(finalChange, remainder)

        OutputView().displayResults(finalChange, unreturnedAmount)
    }

    fun getInitialChange(): Int {
        val change = InputView.enterInitialChange()
        return change
    }


    fun getInitialAmount(): Int {
        val initialAmount = InputView.enterInitialAmount()
        return initialAmount
    }

    fun getChangeCoins(change: Int): List<Change>{
        val changes = mutableListOf<Change>()
        var remaining = change

        Coin.values().forEach {
            changes.add(Change(it, 0))
        }

        while (remaining >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (remaining >= amount) {
                remaining -= amount
                changes.first { it.getCoin() == Coin.from(amount) }.increment()
            }
        }
        return changes.toList()
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

    fun generateVendingMachine(products: List<Product>, totalAmount: Int, minimumCost: Int): Int {
        var currentAmount = totalAmount
        
        while (currentAmount > minimumCost) {
            OutputView().displayInsertedAmount(currentAmount)
            val productName = InputView.enterPurchasingItem()

            val product = products.first { it.getName() == productName }

            if( currentAmount > product.getCost() ) 
                currentAmount -= product.getCost() //TODO: add exceptions
        }

        return currentAmount
    }

    fun returnChange(remainder: Int, coinsInVendingMachine: List<Change>): List<Change> {
        var currentRemainder = remainder
        val returningChange = mutableListOf<Change>()

        for (it in coinsInVendingMachine) {
            val amount = it.getCoin().amount
            if(amount > currentRemainder || it.getCount() == 0) continue
            
            val neededCoinCount = ( currentRemainder / amount )
            val possibleCoinCount = it.getCount()
            
            if (possibleCoinCount > neededCoinCount) {
                currentRemainder -= ( neededCoinCount * amount )
                returningChange.add(Change(Coin.from(amount), neededCoinCount))
            } else {
                currentRemainder -= ( possibleCoinCount * amount )
                returningChange.add(Change(Coin.from(amount), possibleCoinCount))
            }
        }

        return returningChange.toList()
    }

    fun getUnreturnedAmount(coinsReturned: List<Change>, remainder: Int) : Int{
        var unreturnedAmount = remainder
        coinsReturned.forEach{
            unreturnedAmount = remainder - (it.getCount() * it.getCoin().amount)
        }

        return unreturnedAmount
    }

    fun getMinimumCost(products: List<Product>) : Int {
        return products.minOf { it.getCost() }
    }
}