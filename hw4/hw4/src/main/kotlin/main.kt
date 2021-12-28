import arrow.core.andThen
import arrow.core.partially1

fun calculate(vararg params: Pair<(Int) -> Int, Int>): Int {
    val function = params
        .map {
            val v = it.first.partially1(it.second)
            val f = { x: Int -> x + v() }
            f
        }
        .reduce { c, n -> c andThen n }

    return function(0);
}

fun main(args: Array<String>){
    var val1 = Integer.parseInt(args[0])
    var val2 = Integer.parseInt(args[1])
    println(calculate(Pair(plus.partially1(val1), val2)))
    println(calculate(Pair(minus.partially1(val1), val2)))
    println(calculate(Pair(multiplication.partially1(val1), val2)))
    println(calculate(Pair(division.partially1(val1), val2)))
}

val plus = { x: Int, y: Int -> x + y }
val minus = { x: Int, y: Int -> x - y }
val multiplication = { x: Int, y: Int -> x * y }
val division = { x: Int, y: Int -> x / y }