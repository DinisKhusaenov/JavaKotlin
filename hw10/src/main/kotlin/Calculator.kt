package org.example

open class Calculator {

    fun calculate(a: Double, b: Double, operator: String): String {
        var c: Double = 0.0
        if (operator == "+") {
            c = a + b
        } else if (operator == "-") {
            c = a - b
        } else if (operator == "*") {
            c = a * b
        } else if (operator == "/" && b == 0.0) {
            println("Can't divide by 0")
        }else if (operator == "/") {
            c = a / b;
        }
        return c.toString();
    }
}