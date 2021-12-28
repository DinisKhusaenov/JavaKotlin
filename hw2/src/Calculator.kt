class Calculator {
    fun calculate(val1: Int, operation: String, val2: Int): Int {
        if (operator == "/" && val2 == 0) print("Сan't divide by 0")
        else {
            val result = when (operator) {
                "+" -> val1 + val2
                "-" -> val1 - val2
                "*" -> val1 * val2
                "/" -> val1 / val2
                else -> null
            }
	}
    }
}