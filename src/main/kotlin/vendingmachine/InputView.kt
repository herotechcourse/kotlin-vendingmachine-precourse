package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readMoneyAmountMachineHold():Int {
        println("Enter the amount the vending machine holds:")
        return Console.readLine()
            .trim()
            .toIntOrNull()?.takeIf { it > 0 && it % 10 == 0}
            ?: throw IllegalArgumentException("[ERROR] Input must be a positive number divisible by 10.")
    }

    fun readProductInfo(): List<Product> {
        println("Enter product names, prices, and quantities:")
        val userInput = Console.readLine()
            .trim()
            .split(";")
        require(userInput.isNotEmpty()) { "[ERROR] Invalid input." }
        userInput.forEach { product ->
            if (product.startsWith("[") && product.endsWith("]")) {
                product.dropLast(0)
                product.drop(0)
            }
            throw IllegalArgumentException("[ERROR] Invalid Input.")
        }
        val products = userInput.map { product ->
            val productInfo = product.split(",")
            val productName = productInfo[0]
            val productPrice = productInfo[1]
                .toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Invalid input.")
            val productQuantity = productInfo[2]
                .toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Invalid input.")
            Product(productName, productPrice, productQuantity)
        }
        return products
    }
}