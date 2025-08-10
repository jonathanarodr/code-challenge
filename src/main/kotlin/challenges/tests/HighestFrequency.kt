package challenge

fun findHighestFrequencyLow(input: IntArray): Int {
    var elementWithHighestFrequency = -1
    var maxFrequency = 0

    for (i in input.withIndex()) {
        var frequency = 0

        for (j in input.withIndex()) {
            if (i.value == j.value) {
                frequency += 1
            }
        }

        if (frequency > maxFrequency) {
            elementWithHighestFrequency = i.value
            maxFrequency = frequency
        }
    }

    return elementWithHighestFrequency
}

fun findHighestFrequencyFast(input: IntArray): Int {
    val elementFrequency = mutableMapOf<Int, Int>()
    var elementWithHighestFrequency = -1
    var maxFrequency = 0

    for (i in input.indices) {
        val element = input[i]
        elementFrequency[element] = (elementFrequency[element] ?: 0) + 1
    }

    elementFrequency.forEach {
        if (it.value > maxFrequency) {
            elementWithHighestFrequency = it.key
            maxFrequency = it.value
        }
    }

    return elementWithHighestFrequency
}


fun main() {
    val input = intArrayOf(1, 1, 1, 1, 2, 2, 3, 4)
    val result = findHighestFrequencyFast(input)

    println("Max frequency is $result")
}