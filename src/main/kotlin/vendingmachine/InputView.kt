package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun initialAmountInput():Int {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()
        return try{
        val initialAmount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be a number.")
        require(initialAmount > 0) {"[ERROR] Amount must be greater than 0"}
        initialAmount
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            initialAmountInput()
        }
    }

    fun productDetailsInput() {
        println ("\nEnter product names, prices, and quantities:")
        val input = Console.readLine()
        val allProducts = input.split(";")
        val productList = mutableListOf<Product>()
        for (product in allProducts)
        {
            val productDetails = product.replace("[","").replace("]","").split(",")
            productList.add(Product(productDetails[0], productDetails[1].toInt(), productDetails[2].toInt()))
        }
        //println(productList[0].toString())
        //Product price should be greater than 100 and divisible by 10
    }

    fun productPurchaseAmountInput() :Int {
        println("\nPlease enter the amount of money:")
        val input = Console.readLine()
        return try{
            val purchaseAmount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be a number.")
            require(purchaseAmount > 0) {"[ERROR] Amount must be greater than 0"}
            purchaseAmount
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            productPurchaseAmountInput()
        }
    }

    fun productPurchaseName(remainingAmount: Int): String {
        println("\nInserted amount: $remainingAmount KRW")
        println("Please enter the name of the product to purchase:\n")
        return try {
            val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Product Name cannot be empty")
            input.removeWhiteSpaces()
        } catch (e : IllegalArgumentException) {
            println("${e.message}")
            productPurchaseName(remainingAmount)
        }
    }

    private fun String.removeWhiteSpaces() = replace(" ","")
}
