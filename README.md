# kotlin-vendingmachine-precourse

A vending machine that returns change using the fewest number of coins possible. 
Coins are generated randomly and users can add and purchase products to/from the vending machine.🍬🍫🏧🧃🍭💳

## Features

### UI
#### User Input
- [ ] initial amount of money the vending machine holds
- [ ] product names, prices, and quantities in the following format: <br/>
`[Cola,1500,20];[Soda,1000,10]`
- [ ] amount of money for buying products
- [ ] name(s) of the product(s) to purchase
- [ ] on **invalid input**, IllegalArgumentException is thrown followed by a message: <br/>
`[Error]: {error message}`

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





