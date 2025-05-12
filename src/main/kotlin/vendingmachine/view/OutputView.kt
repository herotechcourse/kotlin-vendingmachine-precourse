package vendingmachine.view

class OutputView {

    fun displayInsertedAmount(amount: Int) {
        println()
        println(Messages.INSERTED_AMOUNT + amount + "KRW")
    }

    companion object Messages {
        const val INSERTED_AMOUNT = "Inserted amount:"
    }
}