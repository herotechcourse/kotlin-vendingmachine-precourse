package vendingmachine

fun main(){
    val drinks = listOf(
        Drink("Cola", 1500,20),
        Drink("Soda", 1000, 10)
    )

    val vendingMachine = vendingMachine(drinks)
    println("Welcome to vending machine")

    fun showPurchase(drink: Drink?){
      println("You bought a ${drink?.name}!")
    }

    fun showRemainingMoney(money:Int){
        println("Remaining Money : ${money}")
    }

}

