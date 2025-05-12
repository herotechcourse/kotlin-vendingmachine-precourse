package vendingmachine

import camp.nextstep.edu.missionutils.Console

class InputView {
    val outputView = OutputView()
    fun setupAmountOfCoins(): Int {
        outputView.askSellerMachineAmount()
        val amount = Console.readLine().toInt()
        return amount
    }

    fun setupProduct(): MutableList<String> {
        val product = mutableListOf<String>()
        outputView.askSellerProductName()
        val name = Console.readLine()
        outputView.askSellerProductPrice()
        val price = Console.readLine()
        outputView.askSellerProductQuantity()
        val quantity = Console.readLine()
        product.add(name)
        product.add("KRW $price")
        product.add(quantity)

        return product
    }
}