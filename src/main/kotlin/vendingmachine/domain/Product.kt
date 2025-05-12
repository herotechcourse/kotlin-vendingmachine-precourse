package vendingmachine.domain

class Product private constructor(val name: String, val price: Int, val quantity: Int){


    companion object {
        fun create(name: String, price:Int, quantity: Int): Product {
            println("stat creating")
            require(name.isNotBlank()) { "Product name must not be blank" }
            //require(price % 10 == 0 && price >= 100) { "Product prices start at 100 KRW and must be divisible by 10." }
            return Product(name, price, quantity)
        }


    }



}