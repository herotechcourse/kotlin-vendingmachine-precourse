package vendingmachine.service
import vendingmachine.domain.Coin

class VendingMachine(private var amount: Int) {

    fun generateCoinsVendingMachine(amount: Int): Map<Coin, Int>{

        val result = mutableMapOf<Coin, Int>()
        //var tempAmount: Int = amount

        while (this.amount != 0) {
            if(amount % 500 == 0){
                val count_500 = this.amount/500
                for(i in 1..count_500 ){
                    val coin = Coin.from(500)
                    result[Coin.COIN_500] = result.getOrDefault(coin, 0) + 1

                    this.amount -= 500
                }

            }
            if(amount % 100 == 0){
                val count_100 = this.amount/100
                for(i in 1..count_100 ){
                    val coin = Coin.from(100)
                    result[Coin.COIN_100] = result.getOrDefault(coin, 0) + 1

                    this.amount -= 100
                }

            }
            if(amount % 50 == 0){
                val count_50 = this.amount/50
                for(i in 1..count_50 ){
                    val coin = Coin.from(50)
                    result[Coin.COIN_50] = result.getOrDefault(coin, 0) + 1

                    this.amount -= 50
                }

            }
            if(amount % 10 == 0){
                val count_10 = this.amount/10
                for(i in 1..count_10 ){
                    val coin = Coin.from(10)
                    result[Coin.COIN_10] = result.getOrDefault(coin, 0) + 1

                    this.amount -= 10
                }

            }

        }

        return result

    }


}

