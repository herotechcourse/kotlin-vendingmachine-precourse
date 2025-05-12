package vendingmachine.exception

sealed class VendingMachineException(message: String): IllegalArgumentException("[ERROR] $message") {
    class InvalidInputException(): VendingMachineException("Invalid Input.")
}