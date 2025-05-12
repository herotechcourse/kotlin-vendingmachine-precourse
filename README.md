# kotlin-vendingmachine-precourse
## Project Structure
Coin.kt #Enum for coin types
domain/Product.kt #Product entity
domain/Inventory.kt #Manages product stocks
domain/ Wallet.kt #Handles balance and change

view/InputView.kt #User input handling
view/OutputView.kt #Console output logic

service/VendingMachine.kt #Core logic of vending machine

ProductTest.kt
InventoryTest.kt
WalletTest.kt
VendingMachineTest.kt

## Features

### Coin Handling
- Supports 4 coin types: 500, 100, 50, 10 KRW
- Calculate optimal change using available coins
- Reports any amount that can't be returned

### Product Management
- Loads products with name, price and quantity
- Validates product availability
- Updates inventory after purchase

### Purchase Flow
- Accepts initial amount from user
- Allows purchasing for the available balance
- Subtracts product price from amount after purchase

### Input and Validation
- Rejects invalid product names or not available items
- Displays '[ERROR]' and allows retry when input  is invalid

### Output
- Prints inserted amount and products
- Shows returned change in coins
- Shows leftover change that couldn't be returned