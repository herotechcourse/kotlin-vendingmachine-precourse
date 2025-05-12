# kotlin-vendingmachine-precourse

## Feature List

- InputView
  - take amount of money to initialize machine hold
    - divisible by 10
  - take product info to initialize machine
    - format: `[name,price,quantity];[name2,price2,quantity]`
  - take the amount of money from user
  - take name of product to purchase
- OutputView
  - display holding coins
  - display remaining amount of money for user
  - display change to be returned
  - if needed, display amount of change unable to return
- Machine
  - initiation
    - generating amounts of coin randomly
      - No additional coins created
  - returning change
    - use the fewest number of coins
    - if cannot return the full amount
      - return as much as possible
      - display amount that unreturned
- Product
  - name
  - price
    - start at 100 KRW
    - must be divisible by 10
  - quantity
- Exception
  - error message starts with "[ERROR]"
  - allowed: `IllegalArgumentException` or `IllegalStateException`
  - no generic `Exception`
