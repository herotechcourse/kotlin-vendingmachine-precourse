package vendingmachine
fun paresDetails(input: String): List<String>{
    return input.split(",").map{it.trim()}
}

fun main(){
    println("Welcome to vending machine")
    println("Enter the amount the vending machine holds: ")
    println("Enter product names, prices, and quantities: ")
    val drinks = listOf(
        Drink("Cola", 1500,20),
        Drink("Soda", 1000, 10)
    )

    println("Please enter the amount of money: ")
    val vendingMachine = vendingMachine(drinks)


    fun showPurchase(drink: Drink?){
      println("You bought a ${drink?.name}!")
    }

    fun showRemainingMoney(money:Int){
        println("Remaining Money : ${money}")
    }

}

