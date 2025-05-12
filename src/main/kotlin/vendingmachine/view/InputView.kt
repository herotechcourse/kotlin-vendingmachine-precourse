package vendingmachine.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getVMAmount(): Int{
        print("Enter the amount the vending machine holds: ")
        return Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Amount of coins available in VM must be an integer.")
    }

    fun getProduct(){
        println("Enter product names, prices, and quantities: ")
        val productNameStr = Console.readLine()
        val productList = getProductsList(productNameStr)
        productList.forEach { getProductDetails(it) }
    }

    fun getInitialMoney(): Int{
        println("Please enter the amount of money:")
        val initialMoney = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Amount must be an integer.")
        validateInitialMoney(initialMoney)
        return initialMoney
    }

    fun getRequestedProducts(){
        println("Please enter the name of the product to purchase: ")
        val product = Console.readLine()

    }

    companion object {
        private fun validateInitialMoney(initialMoney: Int){
            if(initialMoney < 0)
                throw IllegalArgumentException("[ERROR] Amount must be non-negative integer")
            if(initialMoney%10 != 0)
                throw IllegalArgumentException("[ERROR] Amount must be divisible by 10")
        }

        private fun validateAmount(){

        }
        private fun validateProductDetails(){

        }

        private fun getProductsList(productNameStr: String): List<String> {
            val productList = productNameStr.split(";")
                .map { it.trim() }
            return productList
        }

        private fun getProductDetails(productList: String): List<String> {
            return productList.split(",", "[", "]")
                .map { it.trim() }
        }

        data class ProductDetails(
            val name: String,
            val price: Int,
            val quantity: Int
        )
    }
}
