# kotlin-vendingmachine-precourse

Implement a vending machine that returns change using the fewest number of coins possible.
It is possible to generate money balance and add products to the machine.

## Features

### Generate cash balance

- Input the amount to be generated
- Validate that amount is divisible by 10
- Reach the amount using random generated coins

### Create products

- Input products in the format [name, price, quantity] separated by ";"
- Validate that prices start from 100 and are divisible by 10 and quantity bigger than 0

### Purchase

- Input amount for purchase
- Display balance for purchase
- Allow next option to purchase until balance is lower than the cheapest product or products are sold out

### Return change

- Calculate the cash to return using the smallest amount of coins
- When balance in the machine is not enough, display unavailable amount to return

## Example execution

```
Enter the amount the vending machine holds:
450

Coins in the vending machine:
500 KRW - 0
100 KRW - 3
50 KRW - 1
10 KRW - 10

Enter product names, prices, and quantities:
[Cola,1500,20];[Soda,1000,10]

Please enter the amount of money:
3000

Inserted amount: 3000 KRW
Please enter the name of the product to purchase:
Cola

Inserted amount: 1500 KRW
Please enter the name of the product to purchase:
Soda

Inserted amount: 500 KRW
Change returned:
100 KRW - 3
50 KRW - 1
10 KRW - 10

Unable to return: 50 KRW
```