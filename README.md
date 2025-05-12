# kotlin-vendingmachine-precourse

### Features
#### categories of features
- input, output, data, check, behavior

#### step1: coin balance
- [x] input : getCoinBalance
- [x] data : validateCoinBalance
  - is not empty
  - is valid digits
  - is greater than 10 (probably)
  - is divisible by 10 (probably)
#### step2: coin balance of vending machine
- [ ] behavior : generateCoinBalance
  - function to use: Randoms.pickNumberInList() from camp.nextstep.edu.missionutils.Randoms.
  - prohibited: no additional coins beyond given CoinBalance
- [ ] output : displayCoinBalance
```
500 KRW - 0
100 KRW - 3
50 KRW - 1
10 KRW - 0
```
#### step3: inventory of products
- [ ] input : getRemainingProductsInfo
- [ ] data : validateRemainingProductsInfo (?)
maybe not necessary, can use while(ture)
```
[Cola,1500,20];[Soda,1000,10]
``` 
#### step4: inserted amount & a purchased product
- [ ] input : getAmountToInsert
it doesn’t need to be displayed at the beginning
- [ ] input : getProductToBuy
- [ ] output : displayInsertedAmount
calculate from CurrentBalance, ProductToBuy
i.e. 3000 - 1500(Cola)

### to add later
- checkBalanceAndCheapestProduct, findCheapestProduct, IsTooLittleAmount, immediateReturnAll, ImmediateReturnPart,  getProductToBuy, displayUnableToReturn

### class
- Coin 
- VendingMachine
- RemainingProducts
