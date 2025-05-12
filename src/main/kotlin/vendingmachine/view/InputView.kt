package vendingmachine.view

import vendingmachine.validator.Validator
import camp.nextstep.edu.missionutils.Console

object InputView{
    //TODO: add validation and exception handling
    fun enterInitialChange(): Int {
        println("Enter the amount the vending machine holds:")
        
        val input = Console.readLine().trim()

        val amount = Validator.validateInitialChange(input) 
        return amount
    }

    fun enterInitialAmount(): Int {
        println("Please enter the amount of money:")
        
        val input = Console.readLine().trim()

        val amount = Validator.validateInitialAmount(input)
        
        return amount
    }

    fun enterProducts(): List<String> {
        println("Enter product names, prices, and quantities:")
        
        val input = Console.readLine().trim()
        
        val products = Validator.validateProducts(input)
        return products
    }

    fun enterPurchasingItem(): String {
        println("Please enter the name of the product to purchase:")
        
        val productName = Console.readLine().trim()

        return Validator.validatePurchaseProduct(productName)
    }
}