package vendingmachine

class PurchaseProcess {

    fun startPurchase(initialMoney: Int,
                      inventoryCount: Int){
        if(initialMoney < 100)
            giveChange(initialMoney)
        if(inventoryCount < 1)
            giveChange(initialMoney)



    }

    private fun getSelectedProduct(){

    }

    private fun giveChange(currentBalance: Int){
    }
}