package vendingmachine

import camp.nextstep.edu.missionutils.Console


fun main() {
    // TODO: Implement the programs
    println("Enter the amount the vending machine holds:")
    val vendingAmount: Int = Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] Please enter valid numbers separated by commas.")
    println("Enter product names, prices, and quantities:")
    val productInput: String = Console.readLine()
    println(validateProducts(productInput))
    println("Please enter the amount of money:")
    val buyingAmount: Int? = Console.readLine().toIntOrNull()
    if (buyingAmount != null) {println(generateCoins(buyingAmount))}

}


fun validateProducts(names: String): List<String> {
    var productList = names.split(";").toMutableList()
    for (i in productList) {
        if (!i.startsWith("[") || !i.endsWith("]")) {
            throw IllegalArgumentException("[ERROR] add [].")
        }
        var eachProd = i.dropLast(1).drop(1).split(",").toMutableList()
        if (eachProd.size != 3) {
            throw IllegalArgumentException("[ERROR] Product must contain name, price and quantity.")
        }
        val prod1 = eachProd[1].toIntOrNull()
        val prod2 = eachProd[2].toIntOrNull()
        if (prod1 == null || prod2 == null) {
            throw IllegalArgumentException("[ERROR] Product prices must be numeric.")
        } else if (prod1 % 10 != 0) {
            throw IllegalArgumentException("[ERROR] Product prices must be divisible by 10.")
        } else if (prod1 < 100) {
            throw IllegalArgumentException("[ERROR] Product prices must be at least 100.")
        }
    }

    return productList
}

fun generateCoins(amount: Int): Map<Coin, Int> {
    var remainder: Int
    var numCoins = mutableMapOf<Coin, Int>()
    if ((amount / 500) != 0){
        val five00 = 500 * amount / 500
        println(five00)
        numCoins += Coin.COIN_500 to amount / 500
        remainder = amount - 500
    }

    return numCoins
}
// [tea,100,4];[coke,200,5] Map<Coin, Int>