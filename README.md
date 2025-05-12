# kotlin-vendingmachine-precourse

## Data Structures

- **Product**:
  - Has `name` as a constructor parameter.
  - Holds attributes for price and quantity.
  - Methods to validate purchase, check availability and purchase product
  
- **Vending Machine**:
  - Store initial amount the vending machine holds, as well as a collection of `Products`
  - Method to run machine

## UI Logic
- **InputView**:
  - Ask for and validate:
    - Initial amount machine holds.
    - Machine inventory.
    - User's budget.
    - Product to be purchased.
      
- **OutputView**:
  - Display:
    - Random coins in the machine.
    - Change returned.
    - Change unable to return.

## Service logic:
- **Generate coins**
  - According to initial amount inserted, generate random coins using `Randoms.pickNumberInList()`.
    
- **Keep inventory**
  - Based on user's input, validate and store inventory.

- **Validate purchases**
  - According to user's input, validate purchases and track of the remaining of user's budget.
 
- **End of purchase**
  - If user has no budget left for the cheapest item or if inventory is empty of all items, end purchase and return change when necessary.
