# kotlin-vendingmachine-precourse

A simple vending machine written in Kotlin. Built as part of the final coding test mission.

---

## Features

- The machine randomly generates coins using the initial amount provided.
- When returning change, the machine uses the fewest number of coins possible from its current coin inventory.
- Users can add products to the machine by specifying the product name, price, and quantity.
- Users can purchase products using the amount they have inserted.
- If the remaining balance is less than the price of the cheapest available product, or if all products are sold out, the machine immediately returns change.
- If the machine cannot return the full amount in change, it returns as much as it can, using available coins.
- If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.
- Handle only specific exception types such as IllegalArgumentException or IllegalStateException, not generic Exception.

---

## Tech Stack

- Kotlin 1.9.24
- Visual Studio
- JUnit 5
- AssertJ
- MissionUtils (Randoms, Console)

---

## How to Run

```bash
# On macOS/Linux
./gradlew clean run


---

## Final Checklist

- [x] Program runs using Kotlin 1.9.24
- [x] No indentation deeper than 2 levels
- [x] All tests pass (`./gradlew clean test`)
- [x] Followed AngularJS Git commit message conventions
- [x] Used only approved libraries

---
```
