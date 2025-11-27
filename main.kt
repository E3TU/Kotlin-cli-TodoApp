data class Todo(var id: Int, val description: String, var isCompleted: Boolean = false)

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

    fun complete(id: Int) {
        val todo = todos.find {it.id == id}
        if (todo != null) {
            todo.isCompleted = true
            println("Task ${todo.id} marked as completed!")
        } else {
            println("Task with id $id not found.")
        }
    }

    fun remove(id: Int) {
        val todoIndex = todos.indexOfFirst { it.id == id }
        if (todoIndex != -1) {
            val todo = todos.removeAt(todoIndex)

            println("Task ${todo.id} deleted.")

            reassignIds()
        } else {
            println("Task with id $id not found.")
        }
    }

    private fun reassignIds() {
        var newId = 1
        todos.forEach { todo ->
            todo.id = newId++
        }
        nextId = newId
    }
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
                print("Enter todo number to mark as done: ")
                val todoId = readLine()?.toIntOrNull()
                if (todoId != null) {
                    todoApp.complete(todoId)
                } else {
                    println("Invalid id.")
                }
                println("")
            }
            "4" -> {
                println("")
                print("Enter todo number to delete: ")
                val todoId = readLine()?.toIntOrNull()
                if( todoId != null) {
                    todoApp.remove(todoId)
                } else{
                    println("Invalid id")
                }
                println("")
            }
            "5" -> {
                println("")
                println("Exiting program...")
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
