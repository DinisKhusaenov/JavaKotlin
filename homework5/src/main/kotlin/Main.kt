import arrow.core.Either
import arrow.core.computations.either
import kotlinx.coroutines.runBlocking

suspend fun main(args: Array<String>) {
    runBlocking {
        val r = either<String, Int> {
            val a = parseInt(args[0]).bind()
            val b = parseInt(args[2]).bind()
            calculate(a,args[1], b).bind()
        }
        val rFold = r.fold({it}, {it.toString()})
        println(rFold)
    }
}


fun parseInt(x: String): Either<String, Int> {
    return try {
        Either.Right(x.toInt())
    } catch (e: NumberFormatException) {
        Either.Left("Incorrect number")
    }
}

fun calculate(a: Int, operator: String, b: Int): Either<String, Int> {
    return when (operator) {
        "+" -> Either.Right(a + b)
        "-" -> Either.Right(a - b)
        "*" -> Either.Right(a * b)
        "/" -> Either.Right(a / b)
        else -> Either.Left("Incorrect operator")
    }
}