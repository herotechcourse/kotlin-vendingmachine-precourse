package vendingmachine

import camp.nextstep.edu.missionutils.Console

class VendingMachine {
    fun start() {
        getProductDetails()

        println("Please enter the amount of money:")
        val input = Console.readLine()
        var money = InputValidator.validateVendingMachineAmount(input)

        println("Inserted amount: $money KRW")
        println("Please enter the name of the product to purchase:")

        val product = Console.readLine()

        // logic for calculating the rest of the money and therefore money is var
    }

    private fun getProductDetails() {
        val products = InputValidator.getValidProducts()
        println(products)
        val name = products[0]
        val price = products[1]
        val quantity = products[2]
    }
}