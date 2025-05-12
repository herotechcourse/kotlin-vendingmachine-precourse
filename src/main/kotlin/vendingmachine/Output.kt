package vendingmachine

class OutputView {
    fun promptCoins() {
        print("Enter the amount the vending machine holds: ")
    }

    fun coinsAmount(coinsAmount: Int) {
        println("\nCoins in the vending machine:")
        println("500 KRW - $coinsAmount")
        println("100 KRW -")
        println("50 KRW - ")
        println("10 KRW - ")
    }

    fun promptProduct() {
        print("\nEnter product names, prices, and quantities: ")
    }

    fun promptClientMoney() {
        print("\nPlease enter the amount of money: ")
    }

    fun remainingClientMoney() {
        println("Inserted amount: ")
    }

    fun promptProductPurchase() {
        println("Please enter the name of the product to purchase: ")
    }

    fun changeReturned(){
        println("Change returned:")
    }

    fun error(message: String) {
        println("[ERROR] $message")
    }
}