package vendingmachine

fun main() {
    try {
        val program = Executor()
        program.run()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
