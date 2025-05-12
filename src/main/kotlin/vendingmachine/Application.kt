package vendingmachine

import vendingmachine.views.InputView

fun main() = Application().run()

   class Application {
      fun run() {
         val vendingMachine = VendingMachine()

         val machineAmount = InputView.readMachineAmount()
         vendingMachine.generateCoins(machineAmount)
         OutputView.printCoins(vendingMachine.getCoinInventory())

         val products = InputView.readProducts()
         vendingMachine.setProducts(products)

      }
   }
}
