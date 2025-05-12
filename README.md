# kotlin-vendingmachine-precourse

A vending machine simulator that returns change using the fewest number of coins possible.

1. Prompts user to input the money held by the vending machine

- If invalid, the program must throw an IllegalArgumentException and re-prompt the user.
    ```
    Enter the amount the vending machine holds:
    450
    ```

2. The machine randomly generates coins of 500 KRW, 100 KRW, 50 KRW, and 10 KRW from the input number.

- Coins are generated only for the amount initially entered — no additional coins are created beyond that.
    ```
    Coins in the vending machine:
    500 KRW - 0
    100 KRW - 3
    50 KRW - 1
    10 KRW - 10
    ```

3. Prompts user to input 1 or more [product] they want to buy, product includes name, price and quantity (divided by commas and encapsulated within squared parenthesis). Each product is separated by ";".

- Product prices start at 100 KRW and must be divisible by 10.
- If invalid, the program must throw an IllegalArgumentException and re-prompt the user.
    ```
    Enter product names, prices, and quantities:
    [Cola,1500,20];[Soda,1000,10]
    ```

4. Prompts user to enter the amount they want to use to pay the vending machine

- If invalid, the program must throw an IllegalArgumentException and re-prompt the user.
    ```
    Please enter the amount of money:
    3000
    Inserted amount: 3000 KRW
    ```

5. Prompts user to buy as many products from the vending machine as their payment allows.

- If invalid, the program must throw an IllegalArgumentException and re-prompt the user.
    ```
    Please enter the name of the product to purchase:
    Cola

    Inserted amount: 1500 KRW
    Please enter the name of the product to purchase:
    Soda
    ```

6. The machine stops prompting the user and returns change:

- If the remaining payment budget is less than the cheapest product
- If all products are soldout
  When returning change, the machine uses the fewest number of coins possible from its current coin inventory.
  If the machine cannot return the full amount in change, it returns as much as it can, using available coins.
  It is assumed that bills are not used for change.
    ```
    Inserted amount: 500 KRW
    Change returned:
    100 KRW - 3
    50 KRW - 1
    10 KRW - 10
    ```

7. The machine keeps any unreturned balance remains in the vending machine.
    ```
    Unable to return: 50 KRW
    ```