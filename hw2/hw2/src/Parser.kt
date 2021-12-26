import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class Parser {
    fun checkNumberOfArguments(size: Int) {
        if (size!= 3){
            throw IllegalArgumentException("Ars format is: var1 +|-|/|* var2")
        }
    }

    fun parseIntOrError(s: String): Int {
        try {
            return Integer.parseInt(s)
        } catch (e: NumberFormatException){
            throw NumberFormatException("It is not int")
        }
    }

    fun parseOperatorOrError(s: String): Any {
        if ("+" == s || "-" == s || "*" == s || "/" == s){
            return s
        }else{
            throw IllegalArgumentException("Operator is not supported")
        }
    }


}