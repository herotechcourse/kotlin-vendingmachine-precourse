# kotlin-vendingmachine-precourse

This is the submission for the final coding test for the "Hero Tech Course: Berlin Edition" by [Deniz](https://github.com/deniz-oezdemir).

This project is a console-based vending machine simulation. After the user inputs the machine's change and product details,
the user can make purchases as long as he has sufficient funds. The program execution ends with the machine then calculating the change.

## feature list

The features will be implemented in the following order:

- [x] read change inventory amount from user input
    - [x] validate inventory amount is a number
    - [x] validate inventory amount is divisible by 10
- [x] generate random coins with `Randoms.pickNumberInList()` for inventory
- [x] print coins held by the vending machine

- [x] read product names, prices, and quantities from user input
    - [x] validate product prices
        - [x] product prices start at 100 KRW
        - [x] product prices must be divisible by 10

- [x] read balance amount of money from user input
- [x] print inserted balance amount

- [x] read product to purchase from user input
    - [x] validate that product exists
- [x] calculate new balance of user
- [x] repeat reading product to purchase from user input until
  balance is smaller than cheapest product's price

- [x] for each user input above:
    - [x] handle invalid user input by throwing an `IllegalArgumentException`
        - [x] re-prompt the user for input after an error
    - [x] ensure error messages follow the format: `[ERROR] <message>`

- [x] calculate change as fewest number of coins possible
- [x] print change returned
- [x] print change unable to return if any

