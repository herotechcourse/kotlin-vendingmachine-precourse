package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

fun main() {
   try {

       println("Please enter the purchase amount.")
       val amountInMachine = InputHandler().getAmountMachineHold()
       val coins = CoinMachine().generateCoins(amountInMachine)
       val numCoins = CoinMachine().countNumberOfCoins(coins)
       println("Coins in the vending machine:")
       val displayCoins = OutputHandler().displayCoins(numCoins)

   }catch (e: IllegalArgumentException) {
       println("[ERROR] ${e.message}")
   }
}
