package vendingmachine.view

import vendingmachine.Coin
import vendingmachine.model.Product

class OutputView {

    fun displayInt(input: Int) {
        println("Entered Amount: ${input}")
    }

    fun displayInsertedAmount(amount: Int) {
        println("Inserted amount: ${amount} KRW")
    }

    fun displayCoinChanges(coins: MutableList<Coin>){
        println("Coins in the vending machine:")
        
        println("500 KRW - ${coins.count { it == Coin.COIN_500 }}")
        println("100 KRW - ${coins.count { it == Coin.COIN_100 }}")
        println("50 KRW - ${coins.count { it == Coin.COIN_50 }}")
        println("10 KRW - ${coins.count { it == Coin.COIN_10 }}")
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
