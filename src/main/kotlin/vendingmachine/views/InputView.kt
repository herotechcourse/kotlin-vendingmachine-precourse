package vendingmachine.views

import camp.nextstep.edu.missionutils.Console
import vendingmachine.Config

class InputView {
	fun readCoinSum(): Int {
		println("Enter the amount the vending machine holds:")
		val input = Console.readLine().trim()
		return parseCoinSum(input)
	}

	fun readProductInventory(): List<String> {
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
		fun parseCoinSum(input: String): Int {
			val amount = input.toIntOrNull()
				?: throw IllegalArgumentException("[ERROR] Amount must be a number.")
			require(amount >= 0) {
				"[ERROR] Amount must be at least zero."
			}
			require(amount % Config.MIN_COIN == 0) {
				"[ERROR] Purchase amount must be a positive multiple of ${Config.MIN_COIN}."
			}
			return amount
		}
		fun parseProductInventory(input: String): List<String> {
			val productStrings = input.split(';')
			val regex = Regex(Config.PRODUCT_REGEX)
			for (p in productStrings) {
				require(regex.matches(p)) {
					"[ERROR] String must match product regex ${Config.PRODUCT_REGEX}, e.g. [Cola,1500,20];[Soda,1000,10]"
				}
			}
			return productStrings
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