package vendingmachine

class VendingMachine(inputCoinBalance: String) {
    val coinBalance: Int

    init {
        require(inputCoinBalance.isNotBlank()) {INVALID_EMPTY_STRING}
        coinBalance = inputCoinBalance.toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_TYPE2)
        require(coinBalance >= COIN_UNIT) {INVALID_TYPE3}
        require(coinBalance % COIN_UNIT == 0) {INVALID_TYPE4}
    }

    companion object {
        const val COIN_UNIT = 10
        const val INVALID_EMPTY_STRING = "[ERROR] Input is empty."
        const val INVALID_TYPE2 = "[ERROR]"
        const val INVALID_TYPE3 = "[ERROR]"
        const val INVALID_TYPE4 = "[ERROR]"
    }
}