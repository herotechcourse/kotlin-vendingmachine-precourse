package vendingmachine.view

object InputView {
    fun getMachineBudget(input : String) :Int{
        // TODO: remember to reprompt later
        val payment = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException("Input failed at getRounds(): input was not a number.")
        return payment
    }


}