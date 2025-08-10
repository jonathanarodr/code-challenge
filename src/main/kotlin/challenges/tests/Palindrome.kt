package challenge

private fun checkPalindrome(input: String): Boolean {
    val inputSplit = input.split("")
    val reversedInput = Array(inputSplit.size) { "" }

    for ((i, j) in (inputSplit.lastIndex downTo 0).withIndex()) {
        println(" $i , $j")
        reversedInput[i] = inputSplit[j]
    }

    return reversedInput.joinToString("") == input
}

fun main() {
    val result = checkPalindrome("radar")
    println("Result is $result")
}
