# kotlin-vendingmachine-precourse

This is the submission for the final coding test for the "Hero Tech Course: Berlin Edition" by [Deniz](https://github.com/deniz-oezdemir).

Intro: tbd

## feature list

The features will be implemented in the following order:

- [ ] read change inventory amount from user input
- [ ] generate random coins with `Randoms.pickNumberInList()` for inventory
- [ ] print coins held by the vending machine

- [ ] read product names, prices, and quantities from user input
- [ ] read amount of money from user input
- [ ] print inserted amount

- [ ] read product to purchase from user input
- [ ] calculate new balance of user
- [ ] repeat reading product to purchase from user input until
balance is smaller than cheapest product's price

- [ ]for each user input above:
    - [ ] handle invalid user input by throwing an `IllegalArgumentException`
        - [ ] re-prompt the user for input after an error
    - [ ] ensure error messages follow the format: `[ERROR] <message>`

- [ ] print change returned
- [ ] print change unable to return if any

