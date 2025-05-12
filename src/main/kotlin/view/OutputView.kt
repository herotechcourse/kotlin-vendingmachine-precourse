package view

object OutputView {

    fun announceCoinsInVendingMachine() {
        println("Coins in the vending machine:")
    }

    fun printNumberOfCoin(coin: Int, number: Int) {
        when (coin) {
            500 -> println("500 KRW - $number")
            100 -> println("100 KRW - $number")
            50 -> println("50 KRW - $number")
            10 -> println("10 KRW - $number")
        }
    }

}