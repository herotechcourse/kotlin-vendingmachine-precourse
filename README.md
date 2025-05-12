# kotlin-vendingmachine-precourse

A vending machine that returns change using the fewest number of coins possible. 
Coins are generated randomly and users can add and purchase products to/from the vending machine.🍬🍫🏧🧃🍭💳

## Features

### UI
#### User Input
- [x] initial amount of money the vending machine holds
- [x] product names, prices, and quantities in the following format: <br/>
`[Cola,1500,20];[Soda,1000,10]`
- [x] amount of money for buying products
- [x] name(s) of the product(s) to purchase
- [x] on **invalid input**, IllegalArgumentException is thrown followed by a message: <br/>
`[ERROR]: {error message}`

#### Output
- [ ] display the randomly generated coins in the vending machine in the following format:
`  500 KRW - 0
  100 KRW - 3
  50 KRW - 1
  10 KRW - 10`
- [ ] display the inserted amount
- [ ] display the change returned in the following format:
`  Change returned:
  100 KRW - 3
  50 KRW - 1
  10 KRW - 10`
  - [ ] do not display if 0 coins of a category are returned
  - [ ] display if a certain amount cannot be returned
  - [ ] display a message if the balance and therefor the amount of change is 0

### Business Logic
#### Validates Input
- [ ] If the user inputs invalid data, the program must throw an `IllegalArgumentException` and re-prompt input from that step.

#### Vending Machine
- [ ]  Implement a vending machine that returns change using the fewest number of coins possible
- [x]  The machine randomly generates coins using the initial amount provided
  - [x]  Only 500 KRW, 100 KRW, 50 KRW, and 10 KRW coins are used.
  - [x]  Coins are generated only for the amount initially entered — no additional coins are created beyond that
  - [x]  amount should be divisible by 10
  - [x]  amount cannot be 0

#### Change
- [ ]  When returning change, the machine uses the **fewest number of coins** possible from its current coin inventory
  - [ ]  It is assumed that bills are not used for change

#### Products
- [x]  Users can add products to the machine by specifying the product name, price, and quantity.
  - [x]  Product prices start at 100 KRW and must be divisible by 10.
  - [ ]  ? max amount of products?

#### Purchase and Returning Change
- [ ]  Users can purchase products using the amount they have inserted.
- [ ]  program re-prompts until money is more or equal to the cheapest
- [ ]  If the remaining balance is less than the price of the cheapest available product, or if all products are sold out, the machine immediately returns change.
- [ ]  If the machine cannot return the full amount in change, it returns as much as it can, using available coins.
  - [ ]  Any unreturned balance remains in the vending machine.
  - [ ]  ?output message if balance is 0 and no change is needed?




