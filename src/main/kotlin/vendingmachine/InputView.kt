package vendingmachine

import camp.nextstep.edu.missionutils.Console

class InputView {


    fun setupAmountOfCoins(): Int {
        val amount = Console.readLine().toInt()
        return amount
    }

    fun setupProductName(): String {
        val name = Console.readLine()
        return name
    }
    fun setupProductPrice(): String {
        val readPrice = Console.readLine()
        val price = "KRW $readPrice"
        return price
    }
    fun setupProductQuantity(): String {
        val quantity = Console.readLine()
        return quantity
    }

    fun customerAmount(): Int  {
        val amount = Console.readLine().toInt()
        return amount
    }
    fun customerProduct(): String  {
        val product = Console.readLine()
        return product
    }

}