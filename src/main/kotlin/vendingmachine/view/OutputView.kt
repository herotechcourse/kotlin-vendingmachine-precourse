package vendingmachine.view

import vendingmachine.Coin
import vendingmachine.util.Change
import vendingmachine.model.Product

class OutputView {

    fun displayInt(input: Int) {
        println("Entered Amount: ${input}")
    }

    fun displayInsertedAmount(amount: Int) {
        println("Inserted amount: ${amount} KRW")
    }

    fun displayInitialCoins(coins: List<Change>){
        println("Coins in the vending machine:")
        
        coins.forEach {
            println("${it.getCoin().amount} KRW - ${it.getCount()}")
        }
    }

    fun displayResults(coins: List<Change>, unreturned: Int){
        println("Change returned:")
        
        coins.forEach {
            println("${it.getCoin().amount} KRW - ${it.getCount()}")
        }

        println("Unable to return: ${unreturned}")
    }

    fun displayProducts(products: List<Product>) {
        println("Products: ")

        products.forEach{
            println("name : ${it.getName()}")
            println("cost : ${it.getCost()}")
            println("quantities : ${it.getQuantities()}")
        }   
    }

}
