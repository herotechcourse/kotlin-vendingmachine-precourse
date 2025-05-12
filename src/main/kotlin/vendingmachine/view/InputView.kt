package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getAmountInfo(){
        print("Enter the amount the vending machine holds: ")
        val amount = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("The amount must be an integer.")

    }

    fun getProduct(){
        println("Enter product names, prices, and quantities: ")
        val productNameStr = Console.readLine()
        val productList = getProductsList(productNameStr)
        productList.forEach { getProductDetails(it) }
    }

    private fun getProductsList(productNameStr: String): List<String> {
        val productList = productNameStr.split(";")
            .map { it.trim() }
        return productList
    }

    private fun getProductDetails(productList: String): List<String>{
         return productList.split(",", "[", "]")
            .map { it.trim()}
    }

    data class ProductDetails(
                            val name: String,
                            val price: Int,
                            val quantity: Int
    )
}
