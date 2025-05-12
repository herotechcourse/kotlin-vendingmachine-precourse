package vendingmachine

object outputView{
    fun showWelcome(){
        println("Welcome to Vending machine!")
    }

    fun displayDrinks(drinks: List<Drink>){
        println("Available Drinks:")
        }
    fun showRemainingMoney(money:Int){
        println("Remaining Money: ${money}")
    }
    }