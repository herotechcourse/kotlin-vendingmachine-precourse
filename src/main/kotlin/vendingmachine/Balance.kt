package vendingmachine

data class Balance(var remaining: Int, val coins: Map<Coin, Int>)
