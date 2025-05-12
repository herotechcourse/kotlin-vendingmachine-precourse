package vendingmachine

import java.io.Console
import java.util.*

class ProuctDetail {
    fun getProductName() {
        println ("\nEnter product names, prices, and quantities:")
        val scan = Scanner(System.`in`)
        val input = scan.nextLine().trim();
        for (product in input) {
            println(product)
        }
    }

}