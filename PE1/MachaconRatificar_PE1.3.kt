/*======================================================================================================
* FILE        : MachaconRatificar_PE1.3.kt
* AUTHOR      : Zach Machacon 
*               Josh Ratificar
* DESCRIPTION : Program to manage shirt orders for a bookstore using inheritance and data structures.
* COPYRIGHT   : 19 June, 2024
* REVISION HISTORY:
*   19 June, 2024: V1.0 - File Created
======================================================================================================*/
/*=================================== Program Prompt ==========================================
* 3) A bookstore needs a system to manage shirt orders with quotes from famous authors. The system should
* allow employees to enter order details and store them for end-of-day processing.
===================================================================================================*/

import java.util.*

// Base class for all orders
open class Order(
    val orderNumber: Int,
    val name: String,
    val gender: String
)

// Derived class for shirt orders
class ShirtOrder(
    orderNumber: Int,
    name: String,
    gender: String,
    val color: String,
    val size: String,
    val quote: String,
    val location: String
) : Order(orderNumber, name, gender)

// Class to manage bookstore operations
class Bookstore {
    private val orders: MutableList<ShirtOrder> = mutableListOf()
    private val quoteChoices = mapOf(
        1 to "After a storm comes a calm.",
        2 to "Be kind whenever possible. It is always possible.",
        3 to "Have faith in your abilities!"
    )

    fun addOrder() {
        val scanner = Scanner(System.`in`)
        println("\nEnter your name: ")
        val name = scanner.nextLine().trim()
        
        println("Enter your gender: ")
        val gender = scanner.nextLine().trim()

        println("Choose a shirt color (red, green, black, blue): ")
        val color = scanner.nextLine().trim().toLowerCase()
        
        println("Choose a shirt size (small, medium, large): ")
        val size = scanner.nextLine().trim().toLowerCase()

        println("Choose a quote: ")
        quoteChoices.forEach { (key, value) -> println("$key. $value") }
        val quoteChoice = scanner.nextInt()

        if (quoteChoice !in quoteChoices.keys) {
            println("Invalid choice. Order not added.")
            return
        }
        val quote = quoteChoices[quoteChoice] ?: ""

        println("Where would you like the quote printed? (front/back): ")
        val location = scanner.next().trim().toLowerCase()

        val orderNumber = orders.size + 1
        val newOrder = ShirtOrder(orderNumber, name, gender, color, size, quote, location)
        orders.add(newOrder)
        println("\nOrder added successfully.")
    }

    fun printOrdersSummary() {
        if (orders.isEmpty()) {
            println("\nNo orders to display.")
            return
        }

        println("\nTotal Number of Orders = ${orders.size}")
        println("Order Summary")
        println("--------------------------------------------------------------------------------")
        println("| Order Number | Name         | Gender | Color   | Size  | Quote                           | Location |")
        println("--------------------------------------------------------------------------------")
        
        orders.forEach { order ->
            println("| %-12d | %-12s | %-6s | %-7s | %-5s | %-30s | %-8s |".format(
                order.orderNumber, order.name, order.gender, order.color, order.size, order.quote, order.location))
        }
        
        println("--------------------------------------------------------------------------------")
    }
}

// Main function to run the program
fun main() {
    val bookstore = Bookstore()
    val scanner = Scanner(System.`in`)
    var continueProgram = true

    while (continueProgram) {
        println("\u001b[H\u001b[2J")  // Clear the screen (may not work in all environments)
        println("1. Add Shirt Order")
        println("2. Print Orders Summary")
        println("3. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {
            1 -> bookstore.addOrder()
            2 -> bookstore.printOrdersSummary()
            3 -> continueProgram = false
            else -> println("Invalid choice. Please enter a number between 1 and 3.")
        }
        
        if (continueProgram) {
            println("\nPress Enter to continue...")
            scanner.nextLine()
            scanner.nextLine()
        }
    }
}
