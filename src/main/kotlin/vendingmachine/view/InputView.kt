package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.model.Product
import vendingmachine.util.Validator

class InputView {
    val validator = Validator()

    fun inputMachineBalance(): Int {
        println(Messages.MACHINE_AMOUNT)
        while (true){
            try {
                val input: String = Console.readLine()
                return validator.isValidBalanceInput(input)
            }
            catch (e : Exception) {
                println(e.message)
            }
        }
    }

    fun inputProduct(): MutableList<Product> {
        println(Messages.CREATE_PRODUCTS)
        val productCatalog: MutableList<Product> = mutableListOf<Product>()
        val productInput = Console.readLine()
        val products = productInput.split(";").map { it.trim() }
        products.forEach {product ->
            val listProduct = product.replace("[", "" ).replace("]", "").split(",").map { it.trim() }
            productCatalog.add(Product(listProduct[0], listProduct[1].toInt(), listProduct[2].toInt() ))
        }
        return productCatalog
    }

    companion object Messages {
        const val MACHINE_AMOUNT = "Enter the amount the vending machine holds:"
        const val CREATE_PRODUCTS = "Enter product names, prices, and quantities:"
    }
}