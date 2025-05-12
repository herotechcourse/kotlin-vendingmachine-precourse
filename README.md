# kotlin-vendingmachine-precourse

# Vending Machine Features

## Vendor Setup of the Vending Machine:
- The machine prompt vendor for the amount of coins inserted
    - Machine logic divide amount in coin values randomly
- Machine prompt for products to be stored

## Customer Logic
- Machine prompt for customer for amount of money
- User enters name of product he wants to purchase
- Machine continues asking until one of the following happens:
    - The amount of money entered is not enough to buy anything more
    - The user doesn't want anything more
    - the machine doesn't have anymore products to sell
- Machine returns change using the biggest coins it has
- Could happen that the machine doesn't have specific coin to return te full change