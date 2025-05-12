package vendingmachine.views

import camp.nextstep.edu.missionutils.Console
import vendingmachine.Config
import vendingmachine.Product

class InputView {
	fun readCoinSum(): Int {
		println("Enter the amount the vending machine holds:")
		val input = Console.readLine().trim()
		return parseCoinSum(input)
	}

	fun readProductInventory(): List<Product> {
		print("Enter product names, prices, and quantities:")
		val input = Console.readLine().trim()
		return parseProductInventory(input)
	}

	fun readPurchaseAmount(): Int {
		println("Please enter the purchase amount.")
		val input = Console.readLine().trim()
		return parsePurchaseAmount(input)
	}

	companion object {
		private fun parseAnyNumber(input: String, name: String): Int {
			val number = input.toIntOrNull()
				?: throw IllegalArgumentException("[ERROR] Amount must be a number.")
			require(number >= 0) {
				"[ERROR] $name must be at least zero."
			}
			require(number % Config.MIN_COIN == 0) {
				"[ERROR] Purchase $name must be a positive multiple of ${Config.MIN_COIN}."
			}
			return number
		}

		private fun parseProduct(input: String): Product {
			val cleaned = input.substring(input.indexOf('[') + 1, input.indexOf(']'))
			val substrings = cleaned.split(',')

			val name = substrings[0]
			val price = parseAnyNumber(substrings[1], "price")
			val quantity = substrings[2].toIntOrNull()
				?: throw IllegalArgumentException("[ERROR] Quantity must be a number.")
			require(quantity >= 1) {
				"[ERROR] $name must be at least 1."
			}

			return Product(name, price, quantity)

		}

		fun parseCoinSum(input: String): Int {
			return parseAnyNumber(input, "amount")
		}

		fun parseProductInventory(input: String): List<Product> {
			val productStrings = input.split(';')
			val regex = Regex(Config.PRODUCT_REGEX)

			val products = arrayListOf<Product>()

			for (p in productStrings) {
				require(regex.matches(p)) {
					"[ERROR] String must match product regex ${Config.PRODUCT_REGEX}, e.g. [Cola,1500,20];[Soda,1000,10]"
				}

				products.add(parseProduct(p))
			}

			return products
		}

		fun parsePurchaseAmount(input: String): Int {
			val amount = input.toIntOrNull()
				?: throw IllegalArgumentException("[ERROR] Invalid purchase amount.")
			require(amount > 0 && amount % Config.MIN_COIN == 0) {
				"[ERROR] Purchase amount must be a positive multiple of ${Config.MIN_COIN}."
			}
			return amount
		}
	}
}