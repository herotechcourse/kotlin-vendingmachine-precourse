# kotlin-vendingmachine-precourse
# Wending Machine

Implement a vending machine that returns change using the fewest number of coins possible.

## Project Overview 

- The machine randomly generates coins using the initial amount provided. Only 500 KRW, 100 KRW, 50 KRW, and 10 KRW coins are used.
- When returning change, the machine uses the fewest number of coins possible from its current coin inventory.
- Users can add products to the machine by specifying the product name, price, and quantity.
- Users can purchase products using the amount they have inserted.
- If the remaining balance is less than the price of the cheapest available product, or if all products are sold out, the machine immediately returns change.
- If the machine cannot return the full amount in change, it returns as much as it can, using available coins.
- If the user inputs invalid data, the program must throw an IllegalArgumentException and re-prompt input from that step.

### I focused on:
- **Clean code**: Meaningful names, small functions, and proper formatting.
- **Error handling**: Catching specific exceptions like `IllegalArgumentException`.
- **User experience**: Clear prompts and output, with retries for invalid inputs.

## Code Structure

### InputView

**Object** responsible for getting input from the user.

### OutputView

**Object** responsible for displaying results to the user.

### Coin 
**Enum** contains the numerical values of coins

## Example Execution

```plain
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