package vendingmachine

class VendingMachine(inputCoinBalance: String) {
    val coinBalance: Int

    init {
        require(inputCoinBalance.isNotBlank()) {INVALID_EMPTY_STRING}
        coinBalance = inputCoinBalance.toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_DIGITS)
        require(coinBalance >= COIN_UNIT) {INVALID_BELOW_MINIMUM}
        require(coinBalance % COIN_UNIT == 0) {INVALID_NOT_DIVISIBLE}
    }

    companion object {
        const val COIN_UNIT = 10
        const val INVALID_EMPTY_STRING = "[ERROR] Input is empty.\n"
        const val INVALID_DIGITS= "[ERROR] Input must be valid digits.\n"
        const val INVALID_BELOW_MINIMUM = "[ERROR] Input must be greater than $COIN_UNIT.\n"
        const val INVALID_NOT_DIVISIBLE = "[ERROR] Input must be divisible by $COIN_UNIT.\n"
    }
}