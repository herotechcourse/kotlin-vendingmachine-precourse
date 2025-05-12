package vendingmachine.model

import vendingmachine.Coin

class VendingMachine(private val coins: MutableList<Coin>, private val products: MutableList<Product>) {
    private var clientAmount: Int = 0

    fun validateUserAmount(amount: Int): Pair<Int, Boolean> {
        val minValue = products.minOfOrNull { it.price } ?: return Pair(amount, false)
        if (minValue > amount) return Pair(amount, false)
        if (products.all { it.quantity == 0 }) return Pair(amount, false)
        return Pair(amount, true)
    }

    fun addClientAmount(amount: Int) {
        clientAmount = amount
    }

    fun returnChange(): Pair<Int, List<Coin>> {
        if (coins.isEmpty()) return Pair(clientAmount,coins)
        val inOrder = coins.sortedByDescending { it.amount }
        var remaining = clientAmount
        val returnCoins = mutableListOf<Coin>()
        for (coin in inOrder) {
            if (remaining - coin.amount >= 0) {
                remaining -= coin.amount
                returnCoins.add(coin)
                coins.remove(coins.first { it.amount ==  coin.amount })
            }
            if (remaining == 0) break
        }
        return Pair(remaining, returnCoins)
    }
}