package vendingmachine.exception

sealed class VendingMachineException(message: String) : IllegalArgumentException("[ERROR] $message") {
    class InvalidInputException() : VendingMachineException("Invalid Input.")

    class InvalidCoinValueException(value: Int) : VendingMachineException("Invalid Coin value: $value.")

    class InvalidProductPriceException(name: String, value: Int) : VendingMachineException("Invalid Product Price: $name: $value.")

    class InvalidProductQtyException(name: String, qty: Int) : VendingMachineException("Invalid Product Quantity: $name: $qty.")

    class InvalidProductNameException(name: String) : VendingMachineException("Product not found: $name")

    class NoProductException(name: String) : VendingMachineException("Product out of stock: $name")
}