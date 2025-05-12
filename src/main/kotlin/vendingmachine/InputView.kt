package vendingmachine

import camp.nextstep.edu.missionutils.Console

object InputView {

	fun readAmountVendingMachine() : Int {
		 return readOrThrow(
			ask = { println(READ_AMOUNT_VENDING_MACHINE) },
			read = { Console.readLine()?.trim()?.toIntOrNull() },
			validate = {
				require(it > 0) {"only positive number is possible to read"}
				require(it % 10 == 0) {"$it can not device by 10, result: ${it % 10}"}
			}
		)
	}

	fun readProducts() : List<Product> {

		val input = readOrThrow (
			ask = { println(READ_PRODUCTS_GIVEN) },
			read = { readAndParseProducts() },
			validate = { require(it.isNotEmpty()) {"invalid input: !! Product can not be empty"} } // TODO
		)
		return input
	}

	fun readUserMoney(): Int {
		return readOrThrow(
			ask = { println(READ_USER_MONEY) },
			read = { Console.readLine()?.trim()?.toIntOrNull() },
			validate = {
				require(it > 0) {"invalid input: only positive number is possible to read"}
				require(it % 10 == 0) {"invalid input: $it can not device by 10, $it % 10 = ${it % 10}"}
			}
		)
	}

	fun readProductPurchase(products: List<Product>): String {
		try {
			println(READ_PURCHASE_PRODUCT)
			val input = Console.readLine()?.trim()
				?: throw IllegalArgumentException("can not read user input")
			require(products.any { it.name == input}) {"can not found $input in products list"}
			return input
		} catch (e: IllegalArgumentException) {
			throw e
		}
	}

	private fun readAndParseProducts(): List<Product> {
		val input = Console.readLine()?.trim()
					?: throw IllegalArgumentException("invalid input: can not read user input")
		val splitToEach = input.split(";").map { it.trim() }
		require(splitToEach.all {it.isNotEmpty()}) {"basic split: empty input found"}

		val removedDelim = splitToEach.map { it.trimStart('[').trimEnd(']') }
		require(removedDelim.all {it.isNotEmpty()}) {"delete '[]' :empty input found"}

		val productList = mutableListOf<Product>()
		removedDelim.forEach {
				productList.add(parseToProductFormat(it.split(","), productList))
			}
		return productList
	}

	private fun parseToProductFormat(splitData: List<String>, productList: MutableList<Product>): Product {
		val name = splitData[0].trim()
		require(productList.all {it.name != name}) {"parse: same name found in the list"}

		val price = splitData[1].toIntOrNull() ?: throw IllegalArgumentException("parse: fail to converse to price ${splitData[1]}")
		val quantity = splitData[2].toIntOrNull() ?: throw IllegalArgumentException("parse: fail to converse to quantity ${splitData[2]}")
		require(price >= 100) {"invalid input: product price too small $name - $price"}
		require(price % 10 == 0) {"invalid input: $price can not divide by 10, $name - $price % 10 = ${price % 10}"}
		return Product(name, price, quantity)
	}


	private fun<T> readOrThrow(
		ask: () -> Unit,
		read: () -> T?,
		validate: (T) -> Unit
	):T {
		try {
			ask()
			val input = read() ?: throw IllegalArgumentException("can not read user input")
			validate(input)
			return input
		} catch (e: IllegalArgumentException) {
			throw e
		}
	}
}