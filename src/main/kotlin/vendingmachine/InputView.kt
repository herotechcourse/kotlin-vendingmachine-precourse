package vendingmachine

import camp.nextstep.edu.missionutils.Console


object InputView {
    fun amountMachineHolds(): Int {
        while (true) {
            try {
                println("Enter the amount the vending machine holds:")
                val amount = Console.readLine().trim().toInt()
                require(amount < 10 || amount / 10 != 0) { Constants.ERROR_INVALID_AMOUNT }
                return amount
            } catch (e: NumberFormatException) {
                println(Constants.ERROR_INVALID_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }


    fun amountInsert(): Int {
        while (true) {
            try {
                println("Please enter the amount of money:")
                val amount = Console.readLine().trim().toInt()
                require(amount < 10 || amount / 10 != 0) { Constants.ERROR_INVALID_AMOUNT }
                return amount
            } catch (e: NumberFormatException) {
                println(Constants.ERROR_INVALID_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun enterTheNameOfTheProduct(): String {
        while (true) {
            try {
                println("Please enter the name of the product to purchase:")
                val productName = Console.readLine().trim()
                val result: Boolean = productName.any() { it.isDigit() }
                require(!result || productName.isEmpty()) { Constants.ERROR_INVALID_NAME_PRODUCT }
                return productName
            } catch (e: NumberFormatException) {
                println(Constants.ERROR_INVALID_NAME)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}


