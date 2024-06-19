/*======================================================================================================
* FILE        : MachaconRatificar_PE1.1.kt
* AUTHOR      : Zach Machacon 
*               Josh Ratificar
* DESCRIPTION : This is my program to hit the requirements of PE1.1 distributed from the class requirements.
* COPYRIGHT   : 19 June, 2024
* REVISION HISTORY:
*   19 June, 2024: V1.0 - File Created
======================================================================================================*/

// Data class for Student
data class Student(var studentId: Int, var name: String = "")

// Function to add a student
fun addStudent(students: MutableList<Student>) {
    if (students.size >= 10) {
        println("\nThe class is already full.")
        return
    }
    
    print("\nEnter the name of the student: ")
    val studentName = readLine()?.trim() ?: ""
    
    if (studentName.isEmpty()) {
        println("\nName cannot be empty. Try again.")
        return
    }
    
    if (students.any { it.name == studentName }) {
        println("\nStudent with this name is already added. Try again.")
        return
    }

    students.add(Student(students.size + 1, studentName))
    println("\nStudent added successfully.")
}

// Function to print the students
fun printStudents(students: MutableList<Student>) {
    if (students.isEmpty()) {
        println("\nNo students to display.")
        return
    }

    // Sorting the students alphabetically by name
    val sortedStudents = students.sortedBy { it.name }

    println("\nLIST OF STUDENTS:\n")
    println("-------------------------------------------------")
    println("| %-10s | %-20s |".format("Student ID", "Name"))
    println("-------------------------------------------------")

    sortedStudents.forEach { student ->
        println("| %-10d | %-20s |".format(student.studentId, student.name))
    }

    println("-------------------------------------------------")
}

// Main Function
fun main() {
    val students = mutableListOf<Student>()
    var isMenu = true

    while (isMenu) {
        // Clear the Screen (might not work in all environments)
        println("\u001b[H\u001b[2J")
        
        println("1. Add Student")
        println("2. Print Students")
        println("3. Exit")
        print("Enter your choice: ")

        val choice = readLine()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> addStudent(students)
            2 -> printStudents(students)
            3 -> isMenu = false
            else -> println("Invalid choice. Please enter a number between 1 and 3.")
        }

        println("\nPress Enter to continue...")
        readLine()
    }
}
