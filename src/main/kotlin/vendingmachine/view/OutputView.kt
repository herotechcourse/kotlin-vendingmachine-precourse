package vendingmachine.view

import vendingmachine.Coin

object OutputView {

    fun output1() {
        println("Enter the amount the vending machine holds:")
    }

    fun output2() {
        println("\nCoins in the vending machine:")
    }

    fun output3(Coins: Map<Coin, Int>) {
        val vendingMachineCoins = StringBuilder()
        vendingMachineCoins.append("500 KRW - ${Coins[Coin.COIN_500]}\n")
        vendingMachineCoins.append("100 KRW - ${Coins[Coin.COIN_100]}\n")
        vendingMachineCoins.append("50 KRW - ${Coins[Coin.COIN_50]}\n")
        vendingMachineCoins.append("10 KRW - ${Coins[Coin.COIN_10]}")
        println(vendingMachineCoins.toString())
    }

    fun output4() {
        println("\nEnter product names, prices, and quantities:")
    }

    fun output5() {
        println("\nPlease enter the amount of money:")
    }

    // T.B.D.
    // REF
    //    fun printNumberOfTickets(nLottos: Int) {
    //        println("\nYou have purchased $nLottos tickets.")
    //    }
    fun output6() {
        // Using $
        // As mush as 'purchasedMoney'
        println("\nInserted amount: 3000 KRW ")
    }

    fun output7() {
        println("Please enter the name of the product to purchase:")
    }

    fun output8() {
        println("")
    }

    fun output9() {
        // Amount as much as un-available to change)
        println("\nUnable to return: 50 KRW")
    }
}

/*
    fun printWinningStatistics(result: Map<String, Int>) {
        println("\nWinning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${result.getOrDefault("3", 0)} tickets")
        println("4 Matches (50,000 KRW) – ${result.getOrDefault("4", 0)} tickets")
        println("5 Matches (1,500,000 KRW) – ${result.getOrDefault("5", 0)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${result.getOrDefault("5+", 0)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${result.getOrDefault("6", 0)} tickets")
    }

    fun printPercent (percentOfWinning : Double) {
        val formatted = String.format("%.1f", percentOfWinning)
        println("Total return rate is $formatted%.")
    }

    fun printTicketsResult ( listLottos: List<List<Int>> ) {
        listLottos.forEach { println(it) }
    }
 */