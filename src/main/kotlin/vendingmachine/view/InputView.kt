package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

object InputView{
    //TODO: add validation and exception handling
    fun enterInitialChange(): Int {
        println("Enter the amount the vending machine holds:")
        
        val input = Console.readLine().trim()
        // require(input.isNotBlank()) { "Input must be entered" }
        val amount = input.toInt() 
        // val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        return amount
    }

    fun enterInitialAmount(): Int {
        println("Please enter the amount of money:")
        
        val input = Console.readLine().trim()
        // require(input.isNotBlank()) { "Input must be entered" }
        val amount = input.toInt() 
        // val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        return amount
    }

    fun enterProducts(): List<String> {
        println("Enter product names, prices, and quantities:")
        
        val input = Console.readLine().trim()
        // require(input.isNotBlank()) { "Input must be entered" }
        
        val products = parseInputBySemicolon(input)
        return products
    }

    fun enterPurchasingItem(): String {
        println("Please enter the name of the product to purchase:")
        
        val productName = Console.readLine().trim()

        return productName
    }

    fun parseInputBySemicolon(input: String): List<String> {
        val products = input.split(";").map { it.trim() }
        // require(products.distinct().size == products.size) { "Member products must be unique." }
        // require(products.all { it.matches(Regex("^[A-Za-z_]{1,5}$")) }) { 
        //     "Member products must contain only letters or underscores and be 1 to 5 characters long." 
        // }
        
        return products;
    }

}