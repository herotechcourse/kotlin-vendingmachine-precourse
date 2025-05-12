package vendingmachine

class OutputHandler{

    fun displayCoins(numscoins:List<Int>){
        println(numscoins)
        println("500 KRW - ${numscoins[0]}")
        println("100 KRW - ${numscoins[1]}")
        println("50 KRW - ${numscoins[2]}")
        println("10 KRW - ${numscoins[3]}")

        }
}