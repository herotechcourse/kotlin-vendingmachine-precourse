package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readMoneyAmount():Int {
        return Console.readLine()
            .trim()
            .toIntOrNull()?.takeIf { it > 0 && it % 10 == 0}
            ?: throw IllegalArgumentException("[ERROR] Input must be a positive number divisible by 10.")
    }

    //  [Cola,1500,20];[Soda,1000,10]
    fun readProductInfo(): List<Product> {
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
            val productQuantity = productInfo[2]
                .toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Invalid input.")
            Product(productName, productPrice, productQuantity)
        }
        return products
    }

}