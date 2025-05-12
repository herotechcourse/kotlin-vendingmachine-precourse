package vendingmachine

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.domen.RandomCoinsGenerator


class VendingMachine(private val coinsGenerator: () -> List<Int> =  {
    listOf(Randoms.pickNumberInList(listOf(500, 100, 50, 10)))
})