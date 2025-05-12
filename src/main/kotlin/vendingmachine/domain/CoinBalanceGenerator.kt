package vendingmachine.domain
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Randoms.pickNumberInList

/*
package study

val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)

fun sumAll(numbers: List<Int>): Int {
    var total = 0
    for (number in numbers) {
        total += number
    }
    return total
}

fun sumAllEven(numbers: List<Int>): Int {
    var total = 0
    for (number in numbers) {
        if (number % 2 == 0) {
            total += number
        }
    }
    return total
}

fun sum(numbers: List<Int>, rule: (Int) -> Boolean = { true }): Int {
    var total = 0
    for (number in numbers) {
        if (rule(number)) {
            total += number
        }
    }
    return total
}

fun main() {
    sum(numbers) { number -> number > 1 }
}


 */
class CoinBalanceGenerator {
    val balance: MutableList<Int> = mutableListOf(0, 0, 0, 0)

//    fun generateCoins(sum: Int) {
//            findRandomNumbersOfCoin(sum, 0, balance)
//    }
//
//    fun findRandomNumbersOfCoin(currentSum: Int, typeIndex: Int, balance: MutableList<Int>): MutableList<Int> {
//        if (currentSum < 10)
//            return balance
//        while(typeIndex <= 3) {
//            balance[typeIndex] = findPossibleNumber(currentSum, typeIndex)
//        }
//    }
//
//    private fun findPossibleNumber(currentSum: Int, typeIndex: Int): Int {
//        val coinValue = convertIndexToValue(typeIndex)
//
//        if (currentSum < coinValue)
//            return -1
//
//        while (currentSum >= 10) {
//            if (typeIndex == 0) {
//                val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
//            } else if (typeIndex == 1) {
//                val amount = Randoms.pickNumberInList(listOf(100, 50, 10))
//            }
//            if (currentSum >= amount) {
//                currentSum -= amount
//                // ...
//            }
//        }
//    }

//    private fun convertIndexToValue(typeIndex: Int): Int{
//        var actualValue: Int = 10
//        when (typeIndex) {
//            0 -> {
//                actualValue = 500
//            }
//            1 -> {
//                actualValue = 100
//            }
//            2 -> {
//                actualValue = 50
//            }
//        }
//        return actualValue
//    }

}