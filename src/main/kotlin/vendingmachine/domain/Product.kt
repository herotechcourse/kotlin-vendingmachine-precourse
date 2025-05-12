package vendingmachine.domain

class Product private constructor(val name: String, val price: Int, val quantity: Int){


    companion object {
        fun create(name: String, price:Int, quantity: Int): Product {
            require(name.isNotBlank()) { "Product name must not be blank" }
            return Product(name, price, quantity)
        }

        fun generateProducts(productList: List<String>){

            for(prod in productList){
                println(prod)
                val produc = prod.split(",").map { it.trim() }
                println(produc[0])
            }

        }
    }



}