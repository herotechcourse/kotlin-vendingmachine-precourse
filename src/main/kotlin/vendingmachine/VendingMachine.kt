package vendingmachine

class VendingMachine(
    var changeInventory: Int,
    var numberOf500Coin: Int = 0,
    var numberOf100Coin: Int = 0,
    var numberOf50Coin: Int = 0,
    var numberOf10Coin: Int = 0
) {

    fun getRandomCoins() {
        while (changeInventory >= 10) {
            val randomCoin = Coin.getRandomCoin()
            if (randomCoin <= changeInventory) {
                addCoin(randomCoin)
                changeInventory -= randomCoin
            } else {
                getRandomCoins()
            }
        }
    }

    private fun addCoin(amount: Int) {
        when (amount) {
            500 -> numberOf500Coin += 1
            100 -> numberOf100Coin += 1
            50 -> numberOf50Coin += 1
            10 -> numberOf10Coin += 1
        }
    }
}