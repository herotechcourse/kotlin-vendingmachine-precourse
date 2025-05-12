package vendingmachine.domain

class MachineProduct(products: String) {
    private val productList = mutableMapOf<String, Product>()

    init {
        val previousProducts = products.split(";")
        for (previousProduct in previousProducts) {
            val removedBracket = previousProduct.removeSurrounding("[", "]")
            val feature = removedBracket.split(",")
            val name = feature[0]
            productList[name] = Product(feature)
        }
    }

    fun getlowestPrice(): Int {
        var lowPrice = Int.MAX_VALUE
        for (product in productList.values) {
            if (product.getPrice() < lowPrice) {
                lowPrice = product.getPrice()
            }
        }
        return lowPrice
    }

    fun purchaseProduct(productName: String): Int {
        val product = productList[productName]!!
        product.purchaseProduct()
        return product.getPrice()
    }

    fun notSoldOut(): Boolean {
        for (product in productList.values) {
            if (product.getQuantity().toInt() >= 1) {
                return true
            }
        }
        return false
    }
}