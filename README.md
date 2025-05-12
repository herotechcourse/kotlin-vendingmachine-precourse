# 🎰 Vending Machine

This project is a simple console-based Vending Machine program written in Kotlin. It simulates a vending machine where user enters product information, initial change, inserting money purchasing item and returning change.

## 📂 Project Structure

```bash
src/
├── domain/ # Core domain logic and model classes
├── controller/ # Application command and flow control
├── view/ # Input and output messages
├── util/ # Utility functions (e.g., validation, parsing)
└── Application.kt # Entry point of the application
```

## 📋 Vending Machine Logic

1. The user enters the amount the vending machine holds initially
2. The program randomly generates the amount of coin it holds at the start.
3. The user enters the products and their information (cost, quantities)
4. The user enters the initial amount of money the user inserted
5. The Vending machine starts working and accepts product requests and deducts costs
6. When the money is not enough to purchase anything from the products, the machine returns the changes
7. Any unreturned change will be printed

8. Invalid inputs throw an `IllegalArgumentException` or `IllegalStateException` and re-prompt the user.

## 🚧 Progress Checklist

- [✅] Set up project structure and build system
- [✅] Create Product class
- [✅] Create VendingMachineManager class
- [✅] Create Enum for Coins
- [✅] Add user input logic
- [✅] Build Coins Generating Logic
- [✅] Build Creating Products logic
- [✅] Build getting minimum product cost Logic
- [✅] Add input validation
- [✅] Build purchasing item logic
- [✅] Build dealing with remaining coins logic
    - [✅] Add getting fewest coins possible logic
- [✅] Add calcuating unreturned remainder
- [✅] Handle exceptions properly
- [✅] Write unit tests for all major components
- [] Enhance Readability
- [] Build Error handling method