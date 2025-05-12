package vendingmachine.service

import vendingmachine.exception.VendingMachineException.InvalidInputException
import vendingmachine.exception.VendingMachineException.InvalidProductPriceException
import vendingmachine.exception.VendingMachineException.InvalidProductQtyException
import vendingmachine.model.Product

object ProductsGeneratorService {
    fun generateWith(input: List<String>): MutableList<Product> {
        val products = mutableListOf<Product>()
        val regex = Regex("\\[(.*?),(\\d*?),(\\d*?)\\]")
        input.forEach {
            val parts = regex.find(it)?.groupValues ?: throw InvalidInputException()
            if (parts.size != 4) throw InvalidInputException()
            val name = parts[1].trim().lowercase().replaceFirstChar { it.uppercase() }
            val price = parts[2].trim().toIntOrNull() ?: throw InvalidInputException()
            if (price % 10 != 0) throw InvalidProductPriceException(name, price)
            val qty = parts[3].trim().toIntOrNull() ?: throw InvalidInputException()
            if (qty < 1) throw InvalidProductQtyException(name, qty)
            products.add(Product(name, price, qty))
        }
        return products
    }
}