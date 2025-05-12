# kotlin-vendingmachine-precourse

## Features
- [ ] User enters the amount the vending machine holds
* Amount must be a number
* Amount must be greater than 0
- [ ] Random number of coins are generated to the sum of the amount entered (Only 500 KRW, 100 KRW, 50 KRW, and 10 KRW coins are used.)
- [ ] User adds product specifying name, price, quantity
* Product name, price, and quantity are entered as comma-separated values. Each product is wrapped in square brackets, and multiple products are separated by semicolons:
[Cola,1500,20];[Soda,1000,10]
* product price starts from 100 KRW and must be divisible by 10
- [ ] User inserts the amount to buy a product
- [ ] User inserts the name of the product to buy
* If the remaining balance is less than the price of the cheapest available product, or if all products are sold out, the machine immediately returns change.
- [ ] User entres the amount of the second product to purchase
- [ ] User enters the name of the second product to purchase
- [ ] The total change to be returned is displayed
- [ ] The possible amount of change that can be returned from the initial amount is calculated
- [ ] Change returned is printed
- [ ] amount unable to return is printed

## Invalid Input Check:
* If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.
* Error messages must start with [ERROR]