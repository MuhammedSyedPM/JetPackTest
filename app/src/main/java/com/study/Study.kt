package com.study

fun isPrime(n: Int): Boolean {
    println("starting")
    if (n <= 1) {
        return false
    }
    if (n <= 3) {
        return true
    }
    if (n % 2 == 0 || n % 3 == 0) {
        println("if")
        return false
    }
    var i = 5
    while (i * i <= n) {
        println(i)
        if (n % i == 0 || n % (i + 2) == 0) {
            return false
        }
        i += 6
    }
    return true
}

fun main() {
    val number = 17 // Change this to check for other numbers
    if (isPrime(number)) {
        println("$number is a prime number.")
    } else {
        println("$number is not a prime number.")
    }
}
