package vendingmachine

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

class ProductInventoryTest {
	@Test
	@DisplayName("purchase possible")
	fun registerProductsCorrectly() {
		val productInventory = ProductInventory()
		val products = listOf<Product>(
			Product("Cola", 1500, 20),
			Product("Soda", 1000, 10),

			)
		productInventory.registerProduct(products[0])
		productInventory.registerProduct(products[1])

		assertThat(productInventory.inventory.keys).isEqualTo(setOf<String>("Cola", "Soda"))
	}


	@Test
	@DisplayName("registers products correctly")
	fun registerProductsCorrectly() {
		val productInventory = ProductInventory()
		val products = listOf<Product>(
			Product("Cola", 1500, 20),
			Product("Soda", 1000, 10),

			)
		productInventory.registerProduct(products[0])
		productInventory.registerProduct(products[1])

		assertThat(productInventory.inventory.keys).isEqualTo(setOf<String>("Cola", "Soda"))
	}

	@Test
	@DisplayName("registers product correctly")
	fun sellProductCorrectly() {
		val productInventory = ProductInventory()
		productInventory.registerProduct(Product("Cola", 1500, 1))
		val price = productInventory.sellItems("Cola")
		assertThat(price).isEqualTo(1500)
	}

	@Test
	@DisplayName("registers product correctly")
	fun sellProductsThrows() {
		val productInventory = ProductInventory()
		productInventory.registerProduct(Product("Cola", 1500, 1))
		assertThatThrownBy { productInventory.sellItems("Cola", 2) }
			.isInstanceOf(IllegalStateException::class.java)
			.hasMessageContaining("[ERROR]")
	}
}