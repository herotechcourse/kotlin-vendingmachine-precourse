package vendingmachine.views

import camp.nextstep.edu.missionutils.Console
import vendingmachine.Product


object InputView {

    fun readMachineAmount() : Int {
        println("Enter the amount the vending machine holds:")
        return readMachineAmount()
    }

    fun readProducts() : List<Product> {
        println("Enter product names, prices and quantities:")
        val input = Console.readLine()
        return input.split(";") .map {
            val values = it.removePrefix("[").removeSuffix("]").split(",")
             if (values.size !=3) throw IllegalArgumentException("[ERROR] Wrong product format")
            val name = values[0]
             val price = values[1].toIntOrNull() ?: throw IllegalArgumentException("[ERROR]Price must be a number")
             val quantity = values[2].toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Quantity must be a number")
             if (price < 100 || price % 10 != 0) throw IllegalArgumentException("[ERROR]Price must be >= 100 and divisible by 10")
            Product(name,price,quantity )
        }

    }
 }