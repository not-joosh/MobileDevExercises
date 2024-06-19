/*======================================================================================================
* FILE        : MachaconRatificar_PE1.1.kt
* AUTHOR      : Zach Machacon 
*               Josh Ratificar
* DESCRIPTION : This is my program to hit the requirements of PE1.1 distributed from the class requirements.
* COPYRIGHT   : 19 June, 2024
* REVISION HISTORY:
*   19 June, 2024: V1.0 - File Created
======================================================================================================*/
/*=================================== Program Prompt ==============================================
* 1 ) A teacher at an elementary school has organized an after-school recreation class. He asks you
* to create a program that will allow him to track which students attend the class. The class only
* accepts 10 students each day. Use an array to store the names and print them alphabetically.
*
* Revise the program from Practice Exercise 11 so that, in addition to storing the student’s name,
* the program also stores the activity each student participates in. Assume that each student’s
* name will be unique and use a dictionary/map object in your solution. The possible activities are:
*     ▪ basketball
*     ▪ floor hockey
*     ▪ arts
*     ▪ checkers
===================================================================================================*/

// Definition of Student in Class
class Student {
    var student_id = 0
    var name = ""
    var activity = ""
}

// Function to add a student
fun addStudent(students: MutableMap<Int, Student>) {
    // Check if the class is full
    if (students.size >= 10) {
        println("Class is full. Cannot add more students.")
        return
    }

    print("\nEnter the name of the student: ")
    val name = readLine()!!

    // Check if the student name already exists
    if (students.any { it.value.name == name }) {
        println("Student with the same name already exists.")
        return
    }

    print("Enter the activity of the student (basketball, floor hockey, arts, checkers): ")
    val activity = readLine()!!

    val student = Student()
    student.name = name
    student.activity = activity
    student.student_id = students.size + 1

    students[student.student_id] = student

    println("\nPress Enter to continue...")
    readLine()
}

// Function to print the students
fun printStudents(students: MutableMap<Int, Student>) {
    // Sorting the students by name
    val sortedStudents = students.values.sortedBy { it.name }

    // Printing the students
    println("\nLIST:\n")
    for (student in sortedStudents) {
        println("Student ID: ${student.student_id} Name: ${student.name} Activity: ${student.activity}")
    }

    println("\nPress Enter to continue...")
    readLine()
}

// Main Function
fun main() {
    // Map to store the names and activities of the students
    val students = mutableMapOf<Int, Student>()
    var isMenu = true
    var choice = 0

    // Making a menu
    while (isMenu) {
        // Clearing the Screen`
        println("\u001b[H\u001b[2J")

        // Printing the menu
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