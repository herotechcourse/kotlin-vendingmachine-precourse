package vendingmachine

import camp.nextstep.edu.missionutils.Console
import kotlin.collections.mutableMapOf

object InputView {
    private fun getInitialAmount() : Int? {
        println("Enter the amount the vending machine holds:")
        val initialAmountStr = Console.readLine()
        return (initialAmountStr.toIntOrNull())
    }

    private fun validateInitialAmountInput(initAmountToValidate : Int?) : Int {
        require (initAmountToValidate != null) {"[ERROR] Please input a valid number"}
        getInitialAmount()
        return initAmountToValidate
    }

    fun handleInitialAmountInput() : Int {
        val initAmount = getInitialAmount()
        return (validateInitialAmountInput(initAmount))
    }

    private fun getProductsInventory() : String {
        println("Enter product names, prices, and quantities:")
        return (Console.readLine())
    }

    private fun validateInventory(inventoryString : String) : MutableList<List<String>>? {
        val productsString = inventoryString.split(";")
        val inventoryList = mutableListOf<List<String>>()
        var newProduct : List<String>

        for (product in productsString) {
            newProduct = validateProducts(product) {
                inventoryList.add(newProduct)
            } else {
                //throw error and prompt back
            }
        }
    }

    private fun validateProducts(productString : String) : List<String> {
        var productList = listOf<String>()
        if (productString[0] == '[' && productString[productString.length - 1] == ']') {
            productString.removePrefix("[")
            productString.removeSuffix("]")
            productList = productString.split(",")
        } else {
            throw IllegalArgumentException ("Correct usage: [<Product name>,<Product price>,<Product quantity>]")
        }
        return (productList)
    }

    private fun createInventory(inventoryString : String) : List<Product> {
        //create products and return list of products
    }

    fun handleInventory() : List<Product>? {
        val inputProducts = getProductsInventory()
        return (createInventory(inputProducts))
    }

    private fun getUserBudget() : Int? {
        println("Please enter the amount of money:")
        val userBudgetString = Console.readLine()
        return (userBudgetString.toIntOrNull())
    }

    private fun validateUserBudget(userBudgetToValidate : Int?) : Int {
        require (userBudgetToValidate != null) {"[ERROR] Please input a valid number"}
        getUserBudget()
        return userBudgetToValidate
    }

    fun handleUserBudget() : Int {
        val userBudgetString = getUserBudget()
        return (validateUserBudget(userBudgetString))
    }

    private fun getPurchaseOfProduct() : String {
        println("Please enter the name of the product to purchase:")
        val purchaseString = Console.readLine()
        return (purchaseString)
    }

    private fun validatePurchaseOfProduct(inventory: MutableMap<Product, Int>, purchaseString : String) : Boolean {
        inventory.
    }

    fun handlePurchaseOfProduct(inventory : mutableMapOf<Product, Int>) {
        val purchaseString = getPurchaseOfProduct()
        val productExists = validatePurchaseOfProduct(inventory, purchaseString)
        //logic
    }
}