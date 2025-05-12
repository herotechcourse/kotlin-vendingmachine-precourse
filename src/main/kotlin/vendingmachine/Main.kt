package vendingmachine

fun main(){
    try{
        println("Enter the amount the vending machine holds:")
        val initialInput = Console.readLine()
        val initialAmount = initialInput.toIntorNull()? :throw IllegalArgumentException("[ERROR]")

        val machine = VendingMachine(initialAmount)

        println("Enter products names, prices, and quantity!")
        val productInput = Console.readLine()
        machine.addProducts(productInput)

        machine.insertAmount()
        machine.purchaseLoop()

    }catch (e : IllegalArgumentException){
        println (e.message)
        main()
    }catch (e : IllegalArgumentException){
        println (e.message)
        main()
}
}