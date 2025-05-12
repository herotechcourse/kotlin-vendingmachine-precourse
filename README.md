# kotlin-vendingmachine-precourse

## Project Overview

This is a **Kotlin 1.9.24** project for implementing a vending machine that returns change using the fewest number of coins possible. <br>
The application allows users to randomly generate coins and then add and purchase products from the machine.

---

## Features

- Accepts user input for initial amount and generate coins using only 500 KRW, 100 KRW, 50 KRW, and 10 KRW coins.
- Users can add products to the machine by specifying the product name, price, and quantity entered as comma-separated values.
- Each product has to be wrapped in square brackets, and multiple products have to be separated by semicolons.
- Each product price starts at 100 KRW and must be divisible by 10.
- Accepts user input for inserted amount.
- Users can purchase products using the inserted amount.
- After purchasing a product, the machine displays the remaining balance as inserted amount.
- If the remaining balance is more than the price of the cheapest available product, the users can purchase product again.
- If the remaining balance is less than the price of the cheapest available product, or if all products are sold out, the machine immediately returns change.
- The machine uses the fewest number of coins possible from its current coin inventory to return change.
- The machine doesn't use bills to return change. 
- If the machine is unable to return the full amount in change, it returns as much as it can, using available coins.
- Displays the amount unable to be returned as change (if none then 0 KRW).
- Handles invalid input (throw and re-prompt on IllegalArgumentException) with specific error messages starting with [ERROR].

---

## Programming Requirements

- Programming Language: **Kotlin 1.9.24** only. 
- Entry Point: main() function in Application.kt.
- Libraries: Only Randoms and Console from `camp.nextstep.edu.missionutils`.
- No external libraries or modifications to build.gradle.kts.
- No use of exitProcess() or System.exit().
- Follow Kotlin Coding Conventions: <br>
    - Max 2 levels of indentation.
    - Functions under 10 lines.
    - Avoid using else by using early returns.
- Separate UI logic and business logic: <br>
    - InputView handles inputs.
    - OutputView handles outputs.
- Unit Testing: <br>
  - Use JUnit 5 and AssertJ.
  - Test only business logic (no testing of UI).
- Use provided `Coin.kt` class and only add methods without changing visibility.

---

## Example Usage 

Enter the amount the vending machine holds: <br>
450

Coins in the vending machine: <br>
500 KRW - 0 <br>
100 KRW - 3 <br>
50 KRW - 1 <br>
10 KRW - 10 <br>

Enter product names, prices, and quantities: <br>
[Cola,1500,20];[Soda,1000,10]

Please enter the amount of money: <br>
3000

Inserted amount: 3000 KRW <br>
Please enter the name of the product to purchase: <br>
Cola

Inserted amount: 1500 KRW <br>
Please enter the name of the product to purchase: <br>
Soda

Inserted amount: 500 KRW <br>
Change returned: <br>
100 KRW - 3 <br>
50 KRW - 1 <br>
10 KRW - 10 <br>

Unable to return: 50 KRW

---

## Testing

- All business logic is unit tested with JUnit 5 and AssertJ.
- Exception handling tests ensure invalid inputs are properly managed.

---

## How to Run

- Clone the repository.
- Open with IntelliJ IDEA.
- Run the Application.kt file to start the program.
- Follow the prompts to play!

