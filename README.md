# Vending Machine

A simple vending machine built in Kotlin for the Woowa Hero Tech Academy final mission.

## Description

Implementing a vending machine that returns change using the fewest number of coins possible.
The machine randomly generates coins using the initial amount provided.

Only 500 KRW, 100 KRW, 50 KRW, and 10 KRW coins are used.
Coins are generated only for the amount initially entered — no additional coins are created beyond that.

The vending-machine is text-based and runs in the console. You'll be asked to:

1. Enter product name, price, and quantity (comma-separated, Each product is wrapped in square brackets, multiple products are separated by semicolons.).
2. Enter the amount the vending machine holds
3. Enter the amount of money 
4. Enter the name and product 

Example input:
```
Enter product names, prices, and quantities:
[Cola,1500,20];[Soda,1000,10]

Enter the amount the vending machine holds:
450

Please enter the amount of money:
3000

Please enter the name of the product to purchase:
Cola
```

Example output:
```
Coins in the vending machine:
500 KRW - 0
100 KRW - 3
50 KRW - 1
10 KRW - 10

Inserted amount: 500 KRW
Change returned:
100 KRW - 3
50 KRW - 1
10 KRW - 10

...

Unable to return: 50 KRW
```

## Feature Plan
- Accept vending machine's initial amount and generate random coins (500,100,50,10 KRW)
- Add products with name, price, and quantity 
- Display generated coins 