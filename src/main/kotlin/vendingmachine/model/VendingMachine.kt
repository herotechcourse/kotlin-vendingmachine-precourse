package vendingmachine.model

import vendingmachine.Coin
import vendingmachine.exception.VendingMachineException.InvalidProductNameException
import vendingmachine.exception.VendingMachineException.NoProductException

class VendingMachine(private val coins: MutableList<Coin>, private val products: MutableList<Product>) {
    var clientAmount: Int = 0
        private set

    fun validateUserAmount(amount: Int): Pair<Int, Boolean> {
        val minValue = products.minOfOrNull { it.price } ?: return Pair(amount, false)
        if (minValue > amount) return Pair(amount, false)
        if (products.all { it.quantity == 0 }) return Pair(amount, false)
        return Pair(amount, true)
    }

    fun validateProduct(product: String): String {
        if (products.any { it.name == product }) return product
        throw InvalidProductNameException(product)
    }

    fun purchaseProduct(name: String) {
        if ((products.find { it.name == name }?.quantity ?: 0) <= 0) throw NoProductException()
        val product = products.find {it.name == name} ?: throw InvalidProductNameException()
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