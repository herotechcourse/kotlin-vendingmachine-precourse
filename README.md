# Vending Machine

## Description

Vending Machine Program is an interactive console-based application that returns change using the fewest number of coins possible.
Users can purchase lottery tickets, input winning numbers, and calculate their winnings and profit rate based on the results.

## Features

1. **Enter the Amount of Purchase**

    - Accept user input for the purchase amount.
    - Ensure the purchase amount is divisible by 10.

2. **Generate Coins**

    - Randomly generate coins using the initial amount provided.
    - Only 500 KRW, 100 KRW, 50 KRW, and 10 KRW coins are used.
    - Print the amount of generated coins in vending machine.

3. **Input Product Names, Prices and quantities**

    - Prompt use to add products to the machine by specifying the product name, price, and quantity.
    - Product prices start at 100 KRW and must be divisible by 10.
    - Product name, price, and quantity are entered as comma-separated values. Each product is wrapped in  square brackets, and multiple products are separated by semicolons.
    - Ensure the winning numbers are unique.

4. **Prompt to enter the amount of money**

    - Prompt the user to enter the total amount they are about to insert into the vending machine
    - The amount must be divisible by 100

4. **Calculate the Remaining balance**

    - If the remaining balance is less than the price of the cheapest available product, or if all products are sold out, the machine immediately returns change.
    - If the machine cannot return the full amount in change, it returns as much as it can, using available coins.

5. **Display Results**

   - Display inserted amount.
   - Prompt to enter the name of the prodcut.
   - Display the amount of purchase 
   - Re-prompt the user to enter the name of the next product if the balance left exceeds 100.
   - Otherwise, display the change returned.
   - Display any unreturned balance remains in the vending machine if change cannot be returned.

## Install Dependencies

1. Download and install the latest JDK from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Install Kotlin:
   - **For Mac**: Run the following command in the terminal:
     ```bash
     brew install kotlin
     ```
   - **For Windows**: Download and install Kotlin from [Kotlin](https://kotlinlang.org/docs/command-line.html).

## How to Run

1. Clone the repository.
2. Navigate to the project directory.

### Build

```bash
./gradlew clean build
```

### Run

```bash
java -cp "build/libs/kotlin-lotto-1.0-SNAPSHOT.jar:libs/mission-utils-1.2.0.jar:libs/kotlin-stdlib-1.9.24.jar" lotto.ApplicationKt
```

### Test

```bash
./gradlew clean test
```

#### Jar dependencies such as `kotlin-stdlib-1.9.24` and `mission-utils-1.2.0` are shipped with this repository in the `libs/` folder.

> ` ./gradlew -q dependencies --configuration runtimeClasspath`
>
> org.jetbrains.kotlin:kotlin-stdlib:1.9.24
>
> - Download the jar from:
>   https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib/1.9.24
>
> com.github.woowacourse-projects:mission-utils:1.2.0
>
> - The jar can be found locally in the Gradle cache:
>   ` ~/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.2.0/`

## Make a Fat Jar to Ship to Production

```bash
mkdir build/temp
cd build/temp
jar -xf ../../libs/mission-utils-1.2.0.jar
jar -xf ../../libs/kotlin-stdlib-1.9.24.jar
jar -xf ../../build/libs/kotlin-lotto-1.0-SNAPSHOT.jar
jar -cfm ../../build/libs/kotlin-lotto-1.0-SNAPSHOT-fat.jar ../../manifest.txt *
cd ../..
```

## Start the Game

```bash
java -jar build/libs/kotlin-lotto-1.0-SNAPSHOT-fat.jar
```
