 /*======================================================================================================
* FILE        : MachaconRatificar_PE1.1.kt
* AUTHOR      : Zach Machacon 
*               Josh Ratificar
* DESCRIPTION : This is my program to hit the requirements of PE1.1 distributed from the class requirements.
* COPYRIGHT   : 19 June, 2024
* REVISION HISTORY:
*   19 June, 2024: V1.0 - File Created
======================================================================================================*/
/*=================================== Program Prompt ==========================================
* 1 ) A teacher at an elementary school has organized an after-school recreation class. He asks you
* to create a program that will allow him to track which students attend the class. The class only
* accepts 10 students each day. Use an array to store the names and print them alphabetically.
===================================================================================================*/

// Definition of Student in Class
class Student
{
    var student_id = 0
    var name = ""
}

// Function to add a student
fun addStudent(students: Array<Student>)
{
    // Check if the class is full
    for (i in 0 until 10)
    {
        if (students[i].name == "")
        {
            print("\nEnter the name of the student: ")
            students[i].name = readLine()!!
            students[i].student_id = i + 1
            break
        }
    }
    
    println("\nPress Enter to continue...")
    readLine()
}

// Function to print the students
fun printStudents(students: Array<Student>)
{
    // Sorting the students
    students.sortBy { it.name }

    // Printing the students
    println("\nLIST:\n")
    for (i in 0 until 10)
    {
        if (students[i].name != "")
        {
            println("\nStudent ID: ${students[i].student_id} Name: ${students[i].name}")
        }
    }

    println("\nPress Enter to continue...")
    readLine()
}

// Main Function
fun main() {
    // Array to store the names of the students
    var students = Array<Student>(10) { Student() }
    var isMenu = true
    var choice = 0

    // Making a menu
    while (isMenu) {
        // CLearing the Screen
        println("\u001b[H\u001b[2J")

        // PRinting the menu
        println("1. Add Student")
        println("2. Print Students")
        println("3. Exit")
        print("Enter your choice: ")
        choice = readLine()!!.toInt()

        when (choice) {
            1 -> addStudent(students)
            2 -> printStudents(students)
            3 -> isMenu = false
            else -> println("Invalid choice")
        }
    }
}