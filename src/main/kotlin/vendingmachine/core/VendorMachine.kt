package vendingmachine.core

import vendingmachine.Coin
import vendingmachine.utils.InputView

class VendorMachine(
    val machineAmountHold: Int,
    val machineCoinsHold: Map<Coin, Int>,
    val products: List<Product>
) {

    val machineAmount = machineCoinsHold.entries.sumOf { (coin, count) ->
        coin.amount*count
    }



    fun handlePurchases(userMoneyAmount: Int) {
        var remainingUserMoneyAmount = userMoneyAmount

        while (true) {
            println("Inserted amount: $remainingUserMoneyAmount")
            val nameProductWanted = InputView.readNameProductWanted(products)
            val productWanted = products.find { product -> product.name == nameProductWanted}

            if (productWanted == null) throw IllegalArgumentException ("[Error] Product not found")

            if (remainingUserMoneyAmount < products.minOf { product -> product.price }) {
                giveRest()
                break
            }

            if (productWanted.price > remainingUserMoneyAmount || productWanted.quantity > 0) {
                productWanted.reduceQuantity()
                remainingUserMoneyAmount -= productWanted.price
                continue
            }
            break

        }


        products.forEach { println(it.toString()) }

    }

    private fun giveRest() {
        TODO("Not yet implemented")
    }


}
