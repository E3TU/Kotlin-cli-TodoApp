data class Todo(val id: Int, val description: String, var isCompleted: Boolean = false)

class TodoApp {
    private val todos = mutableListOf<Todo>()
    private var nextId = 1

    fun add(description: String) {
        val todo = Todo(id = nextId++, description = description)
        todos.add(todo)
        println("Added: ${todo.description}")
    }

    fun view() {
        if (todos.isEmpty()) {
            println("Todo list is empty.")
        } else{
            todos.forEach {
                val todoStatus = if (it.isCompleted) "Completed" else "Pending"
                println("${it.id}. ${it.description} - $todoStatus")
            }
        }
    }

    fun complete() {}

    fun remove() {}
}

fun main() {

    val todoApp = TodoApp()

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
                print("Enter todo description: ")
                val description = readLine()?.trim()
                if (description.isNullOrEmpty()) {
                    println("Task description cannot be empty")
                } else{
                    todoApp.add(description)
                }
                println("")
            }
            "2" -> {
                println("")
                todoApp.view()
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
