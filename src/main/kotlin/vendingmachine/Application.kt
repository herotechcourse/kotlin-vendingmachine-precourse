package vendingmachine

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val vendingMachine = VendingMachine()

//    val vendingMachineAmount =  InputView.readValidVendingMachineAmount()
    val vendingMachineAmount =  450
    vendingMachine.generateCoins(vendingMachineAmount)
    OutputView.printGeneratedCoins(vendingMachine.resultMap)

//    val products = InputView.readValidProducts()
    val parsedProducts = InputValidator.parseProducts("[Cola,1500,20];[Soda,1000,10]")
    val products = Product(parsedProducts)
    products.decreaseQuantity("Cola")
    products.showProducts()

//    vendingMachine.setUserBalance(InputView.readValidPurchaseAmount())
    vendingMachine.setBalance(3000)
}
