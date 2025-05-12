package vendingmachine.util

import  vendingmachine.Coin

class Change(
    private val coin: Coin,
    private var count: Int,
) {
    fun getCoin(): Coin = coin
    
    fun getCount(): Int = count

    fun increment() {
        count ++
    }
}
