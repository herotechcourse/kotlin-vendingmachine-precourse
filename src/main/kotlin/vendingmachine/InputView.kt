package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readMoneyAmount(message: String):Int {
        println(message)
        return Console.readLine()
            .trim()
            .toIntOrNull()?.takeIf { it > 0 && it % 10 == 0}
            ?: throw IllegalArgumentException("[ERROR] Input must be a positive number divisible by 10.")
    }

    //  [Cola,1500,20];[Soda,1000,10]
    fun readProductInfo(): List<Product> {
        println("\nEnter product names, prices, and quantities:")
        val userInput = Console.readLine()
            .trim()
            .split(";")
        require(userInput.isNotEmpty()) { "[ERROR] Invalid input." }
        val parsed = userInput.map { product ->
            if (product.startsWith("[") && product.endsWith("]")) {
                product.trim('[').trim(']')
            }
            else {
                throw IllegalArgumentException("[ERROR] Invalid Input.")
            }
        }
        val products = parsed.map { product ->
            val productInfo = product.split(",")
            val productName = productInfo[0]
            val productPrice = productInfo[1]
                .toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Invalid input.")
            require(productPrice % 10 == 0) { "[ERROR] Invalid input." }
            require(productPrice > 100) { "[ERROR] Invalid input." }
            val productQuantity = productInfo[2]
                .toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Invalid input.")
            Product(productName, productPrice, productQuantity)
        }
        return products
    }

    fun readPurchasingProduct(products: List<Product>): Product {
        println("Please enter the name of the product to purchase:")
        val userInput = Console.readLine().trim()
        val productNames = products.map { it.name }
        require(userInput in productNames) { "[ERROR] Invalid input." }
        val targetProduct = products.filter { it.name == userInput }[0]
        require(targetProduct.isProductAvailable()) { "[ERROR] The product is out of stock." }
        return targetProduct
    }

}