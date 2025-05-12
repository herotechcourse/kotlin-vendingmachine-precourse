package vendingmachine

import vendingmachine.exception.VendingMachineException.InvalidCoinValueException

enum class Coin(val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10), ;

    companion object
    {
        fun from(value: Int): Coin = Coin.entries.firstOrNull { it.amount == value } ?: throw InvalidCoinValueException(value)
    }
}
