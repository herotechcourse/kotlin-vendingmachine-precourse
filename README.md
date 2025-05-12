# kotlin-vendingmachine-precourse

This project is part of the **Hero Tech Pre-course**. This repo was created with the purpose of solving the final task, 
which is to implement a **Vending Machine game**. 

## Table of Contents 

1. [Feature List](#feature-list-)
2. [How to Run](#how-to-run)
3. [Testing](#testing)

## Feature list 

### Input handling and validation
- Prompt the user to input the amount the vending machine holds.
  - Validate amount it's a positive integer.
      - If it's not a positive integer, throw [ERROR] and prompt again.
- Prompt the user to input Product name, price, quantity as comma-separated values.
    - Each product is wrapped in square brackets.
    - Multiple products are separated by semicolon.
    - Validate product prices are at least 100 KRW and must be divisible by 10.
- Prompt the user to insert x amount of money.
  - Validate amount it's a positive integer.
      - If it's not a positive integer, throw [ERROR] and prompt again.
- Prompt the user to enter the name of the product to purchase. 
  - Validate the name of the product is a string and is part of the inventory. 
    - If it's not part of the inventory, throw [ERROR] and prompt again. 

### Game logic
- Vending Machine randomly generates coins using the initial amount provided.
  - Only 500 KRW, 100 KRW, 50 KRW, and 10 KRW coins are used.
- Displays coins currently in the vending machine.
- Keeps record of inventory vs inserted amount (remainder)
- If the remaining balance is less than the price of the cheapest available product, or if all products are sold out, the machine immediately returns change.
- If the machine cannot return the full amount in change, it returns as much as it can, using available coins.
  - Any unreturned balance remains in the vending machine.

### Output and results
- Print how many coins are held by the Vending Machine.
- Print current balance (Inserted amount) with format 'XXXX KRW'.
- Print change returned.
- Print unable to return amount 

### Tests
- Implement unit tests using **JUnit 5** and **AssertJ**.
- Unit tests for:
    - Input validation.
    - Game logic and scenarios.
    - Results calculation.

## How to Run

### 1. Via IntelliJ IDEA
1. Open the project in IntelliJ IDEA.
2. Locate the `Application.kt` file (inside `src/main/kotlin/lotto/`).
3. Right-click on the `main` function and select **Run 'ApplicationKt'**.

## Testing

As per Task guidelines, this project uses JUnit 5 and AssertJ for all testing.

You can run tests via:

### 1. IntelliJ IDEA
1. Open the project in IntelliJ IDEA
2. Locate the desired test file inside the test directory.
3. Right-click on the file test class and select Run.

### 2. Terminal

```bash
./gradlew clean test
```