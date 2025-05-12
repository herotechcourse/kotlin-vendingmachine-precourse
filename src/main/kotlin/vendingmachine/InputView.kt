package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {

	fun readAmountVendingMachine() : Int {
		 return retryUtilValidate(
			ask = { println(READ_AMOUNT_VENDING_MACHINE) },
			read = { Console.readLine()?.trim()?.toIntOrNull() },
			validate = {
				require(it > 0) {"only positive number is possible to read"}
				require(it % 10 == 0) {"$it can not device by 10, result: ${it % 10}"}
			}
		)
	}

	private fun<T> retryUtilValidate(
		ask: () -> Unit,
		read: () -> T?,
		validate: (T) -> Unit
	):T {
		while (true) {
			try {
				ask()
				val input = read() ?: throw IllegalArgumentException("can not read user input")
				validate(input)
				return input
			} catch (e: IllegalArgumentException) {
				println("[ERROR]: ${e.message}")
			}
		}
	}
}