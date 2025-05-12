package vendingmachine

import camp.nextstep.edu.missionutils.Console

class VendingMachine {
    fun start() {
        println("Please enter the amount of money:")
        val input = Console.readLine()
        val money = InputValidator.validateVendingMachineAmount(input)
        println("Inserted amount: $money KRW")
        println("Please enter the name of the product to purchase:")
        val product = Console.readLine()
    }
}