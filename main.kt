fun main() {
    while (true) {
        println("Welcome to todo app")
        println("1. Add Todo")
        println("2. Views Todos")
        println("3. Mark Todo as done")
        println("4. Remove Todo")
        println("5. Exit program")
        print("Choose an option: ")

        val option: String = readln()

        when (option) {
            "1" -> {
                println("")
                println("Enter todo description")
                println("")
            }
            "2" -> {
                println("")
                println("Todos: ...")
                println("")
            }
            "3" -> {
                println("")
                println("Enter todo number to mark as done")
                println("")
            }
            "4" -> {
                println("")
                println("Enter todo number to delete")
                println("")
            }
            "5" -> {
                println("")
                println("Exiting program")
                println("")

                break
            }
            else -> {
                println("")
                println("Invalid option try again")
                println("")
            }
        }
    }
}
