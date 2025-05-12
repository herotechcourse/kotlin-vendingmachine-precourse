package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.Product

class InputView {
    fun inputAmount(): Int {
        println("Enter the amount the vending machine holds:")
        val input = Console.readLine()
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

        require(amount > 0) {
            "[ERROR] Amount must be a positive number."
        }

        return amount
    }

    fun productInput(): List<Product> {
        println("\nEnter product names, prices, and quantities:")
        val input = Console.readLine()
            .trim()
            .split(";")
        require(input.isNotEmpty()) {"ERROR product can't be empty"}
        val parsed = input.map { product ->
            if (product.startsWith("[") && product.endsWith("]")) {
                product.trim('[').trim(']')
            }
            else {
                throw IllegalArgumentException("ERROR syntax is: [productName, price, quantity].")
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

    fun inputProduct(products: List<Product>): Product {
        println("Please enter the name of the product to purchase:")
        val userInput = Console.readLine().trim()
        val productNames = products.map { it.name }
        require(userInput in productNames) { "ERROR Invalid input." }
        val targetProduct = products.filter { it.name == userInput }[0]
        require(targetProduct.isProductAvailable()) { "ERROR The product is out of stock." }
        return targetProduct
    }

}

