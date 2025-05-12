# Vending machine repository

## Overview

This program simulates a vending machine where users can purchase items and the machine returns a change. 

## Features

* User should be able to enter the amount the machine is holding

* The machine should generate coins from the amount it holds
* Users should be able to add products to the machine by specifying the product name, price, and quantity.
* Users can purchase products using the amount they have inserted.
* If the remaining balance is less than the price of the cheapest available product, or if all products are sold out, the machine immediately returns change.

* If the machine cannot return the full amount in change, it returns as much as it can, using available coins.

* Error Handling

 ## **Technical Requirements**

 ### Programming Constraints

 * Kotlin 1.9.24
 * No external libraries except provided ones
 * No System.exit() or exitProcess()
 * Strict indentation depth (max 2 levels)
 * Small, focused functions (max 10 lines)
 * Avoid else statements
 * Proper use of Enum classes
 * Separation of business and UI logic

 ### Testing
 * JUnit 5 and AssertJ for unit tests
 * Comprehensive test coverage
 * Parameterized tests where applicable