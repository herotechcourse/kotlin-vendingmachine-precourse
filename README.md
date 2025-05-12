# kotlin-vendingmachine-precourse

### Input
- [ ] Input amount the vending machine holds
- [ ] Input list of product the vending machine holds:
  - each product separated by semi coma and surrounded by squared brackets
  - product specified with product name, price, quantity. Price must be divisible by 10
- [ ] Input amount of money

### Vending machine
- [ ] Generate randomly generate coins regarding provided amount
- [ ] Create list of product with price and quantity the vending machine holds
- [ ] Proceed user order, if the remaining balance is less than the price of the cheapest available product, or if all products are sold out, the machine immediately returns change 
- [ ] Give a change
  - use the fewest numbers of coins possible from a current coin inventory
  - any unreturned balance is remains in the machine

### Output
- [ ] Coins in the vending machine
- [ ] Coins returned as a change
- [ ] Amount unable to return as a change, if 0 output should be 0 KRW
- [ ] Error message must start with [ERROR]