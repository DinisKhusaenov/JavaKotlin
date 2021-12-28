class Calculator {
    fun calculate(val1: Int, operation: String, val2: Int): Int {
        return when (operation) {
            "+" -> val1 + val2
            "-" -> val1 - val2
            "*" -> val1 * val2
            "/" -> val1 / val2
            else -> 0
        }
    }
}