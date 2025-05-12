package vendingmachine

object OutputView {
    private fun generateCoins(initAmount : Int) {
        //generate coins using random according to init amount
        //think later of how to return the coins
    }

    fun displayCoins(initAmount : Int) {
        val coins = generateCoins(initAmount) //improve this
        //print the coins:
        /*Coins in the vending machine:
        500 KRW - 0
        100 KRW - 3
        50 KRW - 1
        10 KRW - 10*/
    }

    private fun updateUserBudget(pricePaid : Int) : Int {
        //update and return budget
        val currentBudget = getUserBudget()
        return (currentBudget - pricePaid)
    }

    fun displayUpdatedUserBudget(pricePaid : Int) : Int {
        val remainingBudget = updateUserBudget(pricePaid)
        //print: "Inserted amount: <remaining budget> KRW
        return remainingBudget
    }

    private fun generateChange(remainingBudget : Int) {
        //starting from 500 and descending, return coins if they are available in the machine
        //think about how to pass information of change
    }

    //still supposed to print unable to return and more end of purchase logic
}