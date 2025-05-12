//package vendingmachine
//
//import camp.nextstep.edu.missionutils.Console
//
//data class ReadProduct(val nameProduct: String, val price: Int, val quantities: Int) {
//
//    fun productNamePricesQuantities(): List<ReadProduct> {
//        while (true) {
//            try {
//                println("Enter product names, prices, and quantities:")
//                val input = Console.readLine()
//                return input.split(";")
//                    .mapNotNull { segment ->
//                        val trimed = segment.trim(input.removePrefix("["), input.removeSuffix("]"))
//
//                        val parts = trimed.split(",").map { it.trim() }
//                        if (parts.size == 3) {
//
//                        }
//                    }
//            } catch (e: NumberFormatException) {
//                println(Constants.ERROR_INVALID_INPUT)
//            } catch (e: IllegalArgumentException) {
//                println(e.message)
//            }
//        }
//    }
//}