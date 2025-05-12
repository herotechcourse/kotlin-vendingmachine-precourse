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

    // fun enterRestrictedItem(name: String): List<String> {
    //     println("Enter ${name}'s restricted Item:")
        
    //     val input = Console.readLine().trim()
    //     // require(input.isNotBlank()) { "Input must be entered" }
        
    //     val restrictedItems = parseInputByComma(input)
    //     return restrictedItems
    // }

    // fun parseInputByComma(input: String): List<String> {
    //     val names = input.split(",").map { it.trim() }
    //     // require(names.distinct().size == names.size) { "Member names must be unique." }
    //     // require(names.all { it.matches(Regex("^[A-Za-z_]{1,5}$")) }) { 
    //     //     "Member names must contain only letters or underscores and be 1 to 5 characters long." 
    //     // }
        
    //     return names;
    // }

}