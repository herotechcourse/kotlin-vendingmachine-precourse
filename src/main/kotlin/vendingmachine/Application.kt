package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

fun main() {
   try {

       println("Please enter the purchase amount.")
       val amountInMachine = InputHandler().getAmountMachineHold()
       val coins = CoinMachine().generateCoins(amountInMachine)
       println(coins)
       val numCoins = CoinMachine().countNumberOfCoins(coins)

   }catch (e: IllegalArgumentException) {
       println("[ERROR] ${e.message}")
   }
}
