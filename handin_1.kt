package com.example.handin_1


fun main() {
    voteAge()
    maxNumber(4, 67, 94)
    minNumber(3,55,23)
    averageResult()
    validCpr("")
    fizzBuzz(100)
    fullName("Lucas Frederik Jacobsen")
    numericalGrade()
    filterWordsByLength("")
}


// Opgave 1
//A person is elligible to vote if his/her age is greater than or equal to 18.
// Define a method to find out if he/she is elligible to vote. Let the user input their age.

fun voteAge() {
    println("Please enter your age: ")

    val inputtedAge = readLine()?.toIntOrNull()
        if (inputtedAge ?: 0 >= 18) {
            println("You are elligibe to vote")
        } else {
            println("You are not elligible to vote")
        }
}



// Opgave 2
//Define two functions to print the maximum and the minimum number respectively among three numbers

fun maxNumber (number1: Int, number2: Int, number3: Int){
    val max = maxOf(number1, number2, number3)
    println("The highest number is: $max")
}


fun minNumber (number1: Int, number2: Int, number3: Int){
    val min = minOf(number1, number2, number3)
    println("The lowest number is: $min")
}




// Opgave 3
//Write a Kotlin function named calculateAverage that takes
// in a list of numbers and returns their average.

fun calculateAverage(numbers: List<Int>): Double {
    var sum = 0.0
    for (num in numbers) {
        sum += num
    }
        return sum/numbers.size.toDouble()
    }

fun averageResult() {
    val numbers = listOf(10,2,50,5,30)
    val average: Double = calculateAverage(numbers)
    println("Average: $average")
}




// Opgave 4
// Write a method that returns if a user has input a valid CPR number.

fun validCpr(cpr: String): Boolean {
    println("Please enter your CPR number")
    val cpr = readLine()?: ""

    if (cpr.length != 10) {
        println("Invalid CPR length.")
        return false

    }//Extract day, month and year parts
    val day = cpr.substring(0,2).toIntOrNull()
    val month = cpr.substring(2,4).toIntOrNull()

    if (day == null || month == null || day > 31 || month >12) {
        println("Invalid day or month")
        return false
    }
    println("CPR number is valid")
    return true
}



// Opgave 5
//Write a program that prints the numbers from 1 to 100. But for multiples of
//three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
//For numbers which are multiples of both three and five print “FizzBuzz”.

fun fizzBuzz(number: Int) {
    println(number)
    for (i in 0..100){
        when {
            i % 5 == 0 && i % 3 == 0 -> println("FizzBuzz")
            i % 5 == 0 -> println("Buzz")
            i % 3 == 0 -> println("Fizz")
            else -> println(i)
        }
    }
}


// Opgave 6
//Write a program that takes your full name as input and displays the abbreviations of the first
// and middle names except the last name which is displayed as it is.
//For example, if your name is Robert Brett Roser, then the output should be R.B. Roser. Or Benjamin Dalsgaard Hughes will be B.D. Hughes

fun fullName(name: String) {
    println("Please enter your full name: ")
    if (!name.isNullOrBlank()) {
        val nameParts = name.split(" ")
        val abbreviationName = buildString {
            for (i in 0 until nameParts.size - 1) {
                append(nameParts[i][0].toUpperCase()).append(".")
            }
        }
        val result = "$abbreviationName ${nameParts.last()}"
        println("Abbreviated Name: $result")
    }
}





// Opgave 7
//Write a program that takes a numerical grade (0-100) as input and prints out the
// corresponding american letter grade. Implement a function calculateGrade that
// takes an integer parameter representing the grade and returns a string representing the letter grade according to the following scale:
//90-100: "A"
//80-89: "B"
//70-79: "C"
//60-69: "D"
//Below 60: "F"

fun numericalGrade() {
    val number = 98

    when (number) {
        in 90..100 -> println("A")
        in 80..89 -> println("B")
        in 79..79 -> println("C")
        in 60..69 -> println("D")
        in 0..60 -> println("F")
    }
}

//Opgave 8
//Write a Kotlin function named filterWordsByLength that takes in a list of strings and a minimum length,
//and returns a list containing only the words that have a length greater than or equal to the specified minimum length.
//Use filter function and lambda expressions

fun filterWordsByLength(string: String) {
    val strings = listOf("Banan", "Volvo", "København", "Hundested", "Kotlin", "Danmark", "Kea")
    val filteredList = strings.filter { it.length >= 7 }

    println("Filtered List:")
    filteredList.forEach { println(it) }
}

