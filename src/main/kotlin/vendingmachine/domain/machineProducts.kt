package vendingmachine.domain

import vendingmachine.domain.Product.Companion.create

class machineProducts(private val products: List<Product>) {

    companion object {


        fun generateProducts(productList: List<String>): List<Product>{

            val listProducts: List<Product> = arrayListOf()

            for(prod in productList){

                val productToBeCreated = prod.split(",").map { it.trim() }
                val productName = productToBeCreated[0].replace("[", "")
                val productQuantity = productToBeCreated[2].replace("]", "")
                val newProduct: Product = create(productName,productToBeCreated[1].toInt() ,productQuantity.toInt())
                listProducts.toMutableList().add(newProduct)
            }
            return listProducts

        }


    }

}