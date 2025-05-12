package vendingmachine

import camp.nextstep.edu.missionutils.Console 
import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.coin

fun main() {
    class VendingMachine(private var initialAmount:Int) {
        private val coinInventory = mutableMapof <Coin, Int>
        private val products = mutableMapof <String, Product>

        init {
            generateCoins()
            printCoins()
        }

private fun generateCoins(){
    var remaining = initialAmount
    coin.valuesDescending.forEach {coinInventory[it] = 0}

     while (remaining >= 10){
        val coin = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
        if (remaining >= coin){
            val enumcoin = coin.values().first {it.amount == coin }
            coinInventory [enumcoin] = coin coinInventory[enumcoin]!! + 1
            remaining -= coin
        }     } 
}

fun addProducts(input : String){
    val regex = Regex ("""\[(.+?),\s*(\d+)]""")
    val matches =  regex.findAll(input)
    for (match in  matches){
        val (name, priceStr, quantityStr) = match.destructured
        val price = priceStr.toIntorNull()
        val quantity = quantityStr.toIntorNull()

        if (price == null || quantity == null) throw IllegalArgumentException("[ERROR]")
        if (price < 100 || price % 10 != 0) throw IllegalArgumentException("[ERROR]")
        products[name] = Product(name, price, quantity)
    }
}

fun insertAmount(){
    println("Please enter the amount of money:")
    val input = Console.readLine()
    insertedAmount = input.toIntorNull()?: throw IllegalArgumentException("[ERROR]")
    println ("inserted amount: ${insertedAmount} KRW")
}
  fun purchaseLoop (){
while (true){
    if (products.values.all {it.quantity == 0} || insertedAmount < products.values.filter {it.quantity > 0}.minOforNull {it.price} ?: Int.MAX_VALUE){
returnChange()
break
    }
    println (" please enter the name of the product to purchase:")
    val name = Console.readLine()
    val product = products[name];? : throw IllegalArgumentException("[ERROR]")
    if (product.quantity == 0) throw IllegalArgumentException("[ERROR]")
    if (insertedAmount < product.price)throw IllegalArgumentException("[ERROR]")

    insertedAmount -= product.price
    product.quantity -=1
    println ("inserted amount :  ${insertedAmount} KRW")

  }
}

private fun returnChange(){
    println("Change returned:")
    val changeToReturn = mutableMapof<Coin, Int>()
    var remaining = insertedAmount

    for (coin in Coin.valuesDescending){
        val count = minOf(remaining / coin.amount, coinInventory[coin] ?: 0)
        if( count > 0){
            changeToReturn[coin] = count
            remaining -= coin.amount * count
            coinInventory[coin] = coinInventory[coin]!! - count
        }
    }
    for ((coin, count)in changeToReturn){
        println ("${coin.amount} KRW - $count")
    }
    println ("Unable to return: $(remaining) KRW")

}
private fun printCoins(){
    println ("Coins in the vending machine!")
    for (coin in Coin.valuesDescending){
        println ("${coin.amount} KRW = ${coinInventory[coin]}")
    }
}
}
      
    

