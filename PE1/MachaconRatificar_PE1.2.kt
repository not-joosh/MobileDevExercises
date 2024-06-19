/*======================================================================================================
* FILE        : MachaconRatificar_PE1.2.kt
* AUTHOR      : Zach Machacon 
*               Josh Ratificar
* DESCRIPTION : This is my program to hit the requirements of PE1.2 distributed from the class requirements.
* COPYRIGHT   : 19 June, 2024
* REVISION HISTORY:
*   19 June, 2024: V1.0 - File Created
======================================================================================================*/

// Data class for Student
data class Student(var studentId: Int, var name: String = "", var activity: String = "")

// Function to add a student
fun addStudent(students: MutableMap<String, Student>) {
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
    
    if (students.containsKey(studentName)) {
        println("\nStudent with this name is already added. Try again.")
        return
    }

    println("Choose an activity for the student:")
    println("1. Basketball")
    println("2. Floor Hockey")
    println("3. Arts")
    println("4. Checkers")
    print("Enter the number corresponding to the activity: ")
    val activityChoice = readLine()?.toIntOrNull()

    val activity = when (activityChoice) {
        1 -> "Basketball"
        2 -> "Floor Hockey"
        3 -> "Arts"
        4 -> "Checkers"
        else -> {
            println("Invalid choice. Student not added.")
            return
        }
    }

    students[studentName] = Student(students.size + 1, studentName, activity)
    println("\nStudent added successfully.")
}

// Function to print the students
fun printStudents(students: MutableMap<String, Student>) {
    if (students.isEmpty()) {
        println("\nNo students to display.")
        return
    }

    // Sorting the students by name
    val sortedStudents = students.values.sortedBy { it.name }

    println("\nLIST OF STUDENTS:\n")
    println("---------------------------------------------------------------")
    println("| %-10s | %-20s | %-15s |".format("Student ID", "Name", "Activity"))
    println("---------------------------------------------------------------")

    sortedStudents.forEach { student ->
        println("| %-10d | %-20s | %-15s |".format(student.studentId, student.name, student.activity))
    }

    println("---------------------------------------------------------------")
}

// Main Function
fun main() {
    val students = mutableMapOf<String, Student>()
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
