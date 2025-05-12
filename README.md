# kotlin-vendingmachine-precourse

Implement a vending machine that returns change using the fewest number of coins possible.

## Requirements

- The machine randomly generates coins using the initial amount provided.
    - Only 500 KRW, 100 KRW, 50 KRW, 10 KRW.
    - Coins are generated only for the amount initially entered — no additional coins are created beyond that.
- Machine returns the fewest number of coins possible. No bills
- User add products with name, price, quantity.
    - Product prices start at 100 and must be divisible by 10!.
- Users can purchase products with the amount inserted.
    - if the remaining balance is less than the price of the cheapest product, or all products sold out, the machine
      immediately returns change.
- The machine returns as much as it can, using available coins.
    - Any unreturned balance remains in the vending machine.
- Invalid input -> throw IllegalArg and re-prompt from the step.

## Features / Flow

1. [ ] Input: Insert vending machine holds:

```
Enter the amount the vending machine holds:
```

- Generate randomly what the machine holds.

```
while (remaining >= 10) {
    val amount = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
    if (remaining >= amount) {
        remaining -= amount
        // ...
    }
}
```

2. [ ] Output: Coins in the vending machine:

```
Coins in the vending machine:
500 KRW - 0
100 KRW - 3
50 KRW - 1
10 KRW - 10
```

3. [ ] Input: Enter products

- format:

```
[Cola,1500,20];[Soda,1000,10]
```

- requirements:
    - Start at 100
    - divisible by 10

4. [ ] Input: Insert amount

```
Please enter the amount of money:
```

- requirements:
    - Returns change if:
        - Remaining balance is less that the cheapest product available.
        - All products sold out.

5. [ ] Output: display inserted amount

```
Inserted amount: 3000 KRW
```

6. [ ] Input: Product name

```
Please enter the name of the product to purchase:
```

7. [ ] Output: display inserted amount

```
Inserted amount: 1500 KRW
```

8. [ ] Output: Back to 4. or return change:

```
Change returned:
100 KRW - 3
50 KRW - 1
10 KRW - 10
```

- If return not complete change:

```
Unable to return: 50 KRW
```
