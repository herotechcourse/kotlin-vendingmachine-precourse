package vendingmachine

object InputView {
    private fun getInitialAmount() : String {
        //ask for input ("Enter the amount the vending machine holds:")
        //return input as str
    }

    private fun validateInitialAmount(initAmountString : String) : Int? {
        //validate if amount is a number, return str converted to int
    }

    fun handleInitialAmount() : Int? {
        //public function that will be called in main
        val initAmountString = getInitialAmount()
        return (validateInitialAmount(initAmountString))
    }

    private fun getProducts() : String {
        //ask for input ("Enter product names, prices, and quantities:")
        //return input as str
    }

    private fun validateProducts(productsString : String) : List<Product> {
        //validate if the input obeys the format: "[Cola,1500,20];[Soda,1000,10]"
        //return createProducts
    }

    private fun createProducts(productsString : String) : List<Product> {
        //create products and return list of products
    }

    fun handleProducts() : List<Product>? {
        //public function that will be called in main
        val inputProducts = getProducts()
        return (validateProducts(inputProducts))
    }

    private fun getUserBudget() : String {
        //ask for input ("Please enter the amount of money:")
        //return input as str
    }

    private fun validateUserBudget(userBudgetString : String) : Int? {
        //validate if amount is a number, return str converted to int
    }

    fun handleUserBudget() : Int? {
        //public function that will be called in main
        val userBudgetString = getUserBudget()
        return (validateUserBudget(userBudgetString))
    }

    private fun getPurchaseOfProduct() : String {
        //ask for input ("Please enter the name of the product to purchase:")
        //return str
    }

    private fun validatePurchaseOfProduct(purchaseString : String) : Boolean {
        //validate if thats an existing product
        //return true or false
    }

    fun handlePurchaseOfProduct() {
        val purchaseString = getPurchaseOfProduct()
        val productExists = validatePurchaseOfProduct(purchaseString)
        //logic
    }
}