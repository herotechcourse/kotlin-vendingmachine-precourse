package vendingmachine

class BalanceAmount {
    fun readBalanceAmount():int {
        println("Please enter the amount of money:")
        val input = readInput()
        validateInputNotEmpty(input)
        val amount = tryToInt(input)
        validateDivisibleByTen(amount)
        return int
    }


}

}