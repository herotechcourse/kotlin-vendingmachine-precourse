package vendingmachine.service

object Validator {
    private const val PREFIX = "[ERROR] "

    fun validateProductForm(input: String) {
        val products = input.split(";")
        for (product in products) {
            require(product.isNotBlank()) { PREFIX + "is empty" }
            require(validateBracket(product)) { PREFIX + "should put inside [ ]" }
            require(validateForm(product)) { PREFIX + "separate by , (comma)" }
        }
    }

    private fun validateBracket(product: String): Boolean {
        if (product[0] == '[' && product[product.length - 1] == ']') {
            return true
        }
        return false
    }

    private fun validateForm(product: String): Boolean {
        val productFeature = product.split(",")
        if (productFeature.size == 3) {
            return true
        }
        return false
    }

    fun validateOnlyNumber(input: String) {
        require(input.matches("^\\d*\$".toRegex())) { PREFIX + "Number only" }
        require(input.isNotBlank()) { PREFIX + "is empty" }
    }
}