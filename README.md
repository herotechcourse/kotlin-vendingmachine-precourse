#### kotlin-vendingmachine-precourse


## Feature List

! tip
```kotlin
```
### basic process 

- [x] [1] get amount the vending machine holds
  - [x] check a validation 
  - [x] change to coins
  - Coins are generated only for the amount initially entered
  - no additional coins are created beyond that.

```text
Coins in the vending machine:
500 KRW - 0
100 KRW - 3
50 KRW - 1
10 KRW - 10
```

- [x] [2] read "Enter product names, prices, and quantities:"
  - format like:
    - Product name, price, and quantity are entered as comma-separated values
    - Each product is wrapped in square brackets, and multiple products are separated by semicolons:

```text
[Cola,1500,20];[Soda,1000,10]
```

- [x] [3] read "Please enter the amount of money:", which user cay buy product(s)
- [x] [4] print header "Inserted amount: `$amount` KRW" each section
- [x] [5] run "Please enter the name of the product to purchase:"
  - till reach -- remaining balance is less than the price of the cheapest available product....
- [ ] [6] the machine immediately returns change
  - If the remaining balance is less than the price of the cheapest available product
  - if all products are sold out

```text
Inserted amount: 500 KRW
Change returned:
100 KRW - 3
50 KRW - 1
10 KRW - 10

Unable to return: 50 KRW
```

**reference from... read value: `get amount the vending machine holds`