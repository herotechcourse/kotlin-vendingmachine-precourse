package vendingmachine

object Inputview{
    fun readMoney(): Int{
        println("Insert Amount: ")
        return readLine()?.toIntOrNull()?:0
    }
    fun readDrinkSelection(): String{
        println("Select drink or 'Exit'")
        return readLine()?:""
    }
}