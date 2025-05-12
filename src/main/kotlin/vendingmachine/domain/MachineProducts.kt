package vendingmachine.domain

class MachineProducts {
    companion object {
        fun generateProducts(productList: List<String>): List<Product> {
            val listProducts = mutableListOf<Product>()
            for (prod in productList) {
                val parts = prod.split(",").map { it.trim() }
                val name = parts[0].removePrefix("[")
                val price = parts[1].toInt()
                val quantity = parts[2].removeSuffix("]").toInt()
                listProducts.add(Product.create(name, price, quantity))
            }
            return listProducts
        }
    }
}