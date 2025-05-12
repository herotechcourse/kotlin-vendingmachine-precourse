package vendingmachine.view

class OutputView {

    fun displayInsertedAmount(amount: Int) {
        println()
        println(Messages.INSERTED_AMOUNT + amount + "KRW")
    }

    fun displayReturnchange(amount: Int){
        displayInsertedAmount(amount)
        println(Messages.CHANGE_RETURN + amount + "KRW")
    }

    companion object Messages {
        const val INSERTED_AMOUNT = "Inserted amount:"
        const val CHANGE_RETURN = "Change returned:"
    }
}