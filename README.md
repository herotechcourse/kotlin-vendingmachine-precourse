# kotlin-vendingmachine-precourse

Implement a vending machine that returns change using the fewest number of coins possible.

## Feature List

1. Validate amount the vending machine holdd.
2. Generate randomly coins in the vendor machine.
3. Add and validate products to the machine by specifying the product name, price, and quantity. Product prices start at 100 KRW and must be divisible by 10.
   Product name, price, and quantity are entered as comma-separated values. Each product is wrapped in square brackets, and multiple products are separated by semicolons:
   [Cola,1500,20];[Soda,1000,10]
4. Validate amount of money inserted by the user
5. Validate the name of the product wanted
6. Handle the purchase 
7. Display the change returned
8. Handle error messages


## How to Run

1. Open the project in IntelliJ IDEA.
2. Locate `src/main/kotlin/lotto/Application.kt`.
3. Run the `main()` function.
4. Alternatively, run via terminal:
    - Linux/macOS: `./gradlew run`
    - Windows: `gradlew.bat run`
5. Run all tests before submitting:
    - `./gradlew clean test`

---

## Requirements

- Kotlin 1.9.24
- JUnit 5 & AssertJ
- Console and Randoms API from `camp.nextstep.edu.missionutils`