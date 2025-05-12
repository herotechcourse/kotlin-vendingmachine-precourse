package vendingmachine.controller

//import vendingmachine.domain.VendingMachine
//import vendingmachine.view.OutputView
import vendingmachine.domain.MachineProduct
import vendingmachine.view.InputView

object MachineController {
    private var initMoney = 0
    private var lowestPrice = Int.MAX_VALUE
    lateinit var machineProduct: MachineProduct

    fun startMachine() {
        initMachineProduct()
        initLowestPrice()
        initUserMoney()
        purchaseTime()
    }

    private fun initMachineProduct() {
        machineProduct = MachineProduct(InputView.input4())
    }

    private fun initLowestPrice() {
        lowestPrice = machineProduct.getlowestPrice()
    }

    private fun initUserMoney() {
        this.initMoney = InputView.input7().toInt()
    }

    private fun purchaseTime() {
        while (initMoney >= lowestPrice && machineProduct.notSoldOut()) {
            val product = getPurchaseProduct()
            initMoney -= machineProduct.purchaseProduct(product)
        }
    }

    private fun getPurchaseProduct(): String {
        val userInputProduct: String
        try {
            userInputProduct = InputView.input7().trim()
        } catch (e: Exception) {
            println(e.message)
            return getPurchaseProduct()
        }
        return userInputProduct
    }
}