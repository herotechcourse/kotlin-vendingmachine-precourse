package vendingmachine.service

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin
import vendingmachine.domain.Inventory
import vendingmachine.domain.Product
import vendingmachine.domain.Wallet

class VendingMachine (private  val coinStock: MutableMap<Coin, Int>) {
    lateinit var inventory: Inventory
        private set

    fun generateCoins(total: Int){

        var remaining = total
        val coins = Coin.valuesDescending()

        while (remaining  >= 10) {
            val amount = Randoms.pickNumberInList(coins.map {
               it.amount
            })
            if (remaining >= amount) {
                val coin = Coin.fromAmount(amount) ?: continue
                coinStock[coin] = coinStock.getOrDefault(coin, 0) + 1
                remaining -= amount
            }
        }
    }

    fun getCoinStock(): Map<Coin, Int> = coinStock.toMap()

    fun setProduct(raw: String) {
        inventory = Inventory.from(raw)
    }

    fun startSession(userWallet: Wallet) {
        while(true) {
            val product = nextAvailableProduct(userWallet. currentBalance()) ?: break
            val name = vendingmachine.view.InputView.readProductNames()
            if (!inventory.isPurchasable(name, userWallet.currentBalance())) continue

            val price = inventory.purchase(name)
            userWallet.deduct(price)

            vendingmachine.view.OutputView.printInsertedAmount(userWallet.currentBalance())

        }
    }

    fun returnChange( userWallet: Wallet): Pair<Map<Coin, Int>, Int>{
        val result = mutableMapOf<Coin, Int>()
        var remaining = userWallet.currentBalance()
        for (coin in Coin.valuesDescending()) {
            val coinValue = coin.amount
            val available  = coinStock.getOrDefault(coin, 0)
            val count = minOf(available, remaining/coinValue)

            if (count>0) {
                result[coin] = count
                coinStock[coin] = available - count
                remaining -= coinValue*count
            }
        }
        return result to remaining
    }

    private fun nextAvailableProduct(balance: Int): Product? =
        inventoryAvailable().minByOrNull {it.price}
            ?.takeIf {it.price <= balance}

    private fun inventoryAvailable(): List<Product> =
        inventory.availableProducts()



}