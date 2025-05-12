package vendingmachine.domain

class CoinBalance(var sum: Int) {
    val balance: MutableList<Int> = mutableListOf(0, 0, 0, 0)

}