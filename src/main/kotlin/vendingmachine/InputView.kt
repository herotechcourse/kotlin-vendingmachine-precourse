package vendingmachine

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readAmountMachineHolds(): String {
        print("Enter the amount the vending machine holds:")
        val input = Console.readLine()

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] Input must be non-empty")
        }

        return input
    }

    fun validateAmountMachineHolds(input: String): Int {
        if (input.toIntOrNull() == null || input.toInt() <= 0) {
            throw IllegalArgumentException("[ERROR] Please enter the valid amount for machine to hold.")
        }

        return input.toInt()
    }

    fun readProductList(): String {
        print("Enter product names, prices, and quantities:")
        val input = Console.readLine()

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] Input must be non-empty")
        }

        return input
    }

    fun processProductsList(input: String): List<Product> {
        val rawProducts = input.split(';')
        val products = mutableListOf<Product>()

        rawProducts.forEach { product ->
            val test = product.removePrefix("[").removeSuffix("]").split(',')
            products.add(Product(test[0], test[1].toInt(), test[2].toInt()))
        }
        return products
    }

    fun readUserMoneyAmount(): String {
        print("Please enter the amount of money:")
        val input = Console.readLine()

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] Input must be non-empty")
        }

        return input
    }

    fun validateUserMoney(input: String): Int {
        if (input.toIntOrNull() == null || input.toInt() <= 0) {
            throw IllegalArgumentException("[ERROR] Please enter the valid amount for machine to hold.")
        }

        return input.toInt()
    }

    fun purchaseReader(): String {
        print("Please enter the name of the product to purchase:")
        val input = Console.readLine()

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] Input must be non-empty")
        }

        return input
    }

}
