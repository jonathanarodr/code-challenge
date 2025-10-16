package br.com.jonathanarodr.challenges.tests

private fun zipAndFindMaxCombination(inputArray: MutableList<Int>): Int {
    val lastIndex = inputArray.lastIndex
    var maxElement: Int = Int.MIN_VALUE

    for (i in 0 until lastIndex) {
        val adjacentCombination = inputArray[i] * inputArray[i+1]
        if (adjacentCombination > maxElement) {
            maxElement = adjacentCombination
        }
    }

    return maxElement
}

fun main() {
//    val input = mutableListOf(1, 0, 1, 0, 1000)
//    val result = zipAndFindMaxCombination(input)
//
//    println("Result is $result")

    val input = ArrayList<Int>()
    input.add(1)
    input.add(2)
    input.add(3)
    input.add(3)
    input.add(3)
    input.add(3)
    input.add(3)
    input.add(3)
    input.add(3)
    input.add(3)
    input.add(3)

//    for (var i = 1; i <= factorial(n); i++) {
//        println(i)
//    }
}
