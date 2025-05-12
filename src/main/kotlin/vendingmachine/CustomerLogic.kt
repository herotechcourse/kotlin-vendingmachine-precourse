package vendingmachine

class CustomerLogic {

    fun treatCustomerPurchase(
        machineAmount: Int,
        products: MutableList<MutableList<String>>,
        customerAmount: Int,
        customerProduct: String
    ) {
        println("machineAmount: $machineAmount")
        println("products: $products")
        println("customerAmount: $customerAmount")
        println("customerProduct: $customerProduct")
    }

}