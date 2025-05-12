package vendingmachine

import camp.nextstep.edu.missionutils.Console
import java.util.*

class Price {
    fun getAmount() {
        println("Please enter the amount Vending meshing hold")
        val scan = Scanner(System.`in`)
        val input = scan.nextLine().trim();
        if (input <= 0.toString()){
            println("Amount must be valied")
        }
    }

}