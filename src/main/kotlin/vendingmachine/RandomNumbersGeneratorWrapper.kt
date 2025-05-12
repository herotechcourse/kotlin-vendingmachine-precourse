package vendingmachine

import camp.nextstep.edu.missionutils.Randoms

interface RandomNumbersGeneratorWrapper {
    fun generateRandomNumbersInList(initialAmount: Int)

}

class RandomNumbersGeneratorWrapperImpl : RandomNumbersGeneratorWrapper {

    override fun generateRandomNumbersInList(initialAmount: Int) {
        var initialAmount = initialAmount
        while (initialAmount >= 10) {
            val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
            if (initialAmount >= amount) {
                initialAmount -= amount
            }
        }
    }
}