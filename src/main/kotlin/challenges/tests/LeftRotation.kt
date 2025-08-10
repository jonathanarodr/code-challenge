package challenge


class LeftRotation {
}

/*
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */
fun moveToLeft(a: Array<Int>) {

}

fun rotLeft(a: Array<Int>, d: Int): Array<Int> { // [1, 2, 3] -> [3, 2, 1]
    val auxiliar = mutableListOf<Int>()
    var reversed = a

    /**
     * [1,2,3]
     * [2,3,1]
     * [3,1,2]
     */
    //lastIndex = 2
    val lastIndex = a.lastIndex

    for (x in 1..d) {
        auxiliar.clear()

        for (i in 0..lastIndex-1) { //0..1
            //x = 1 [1,2,3]
            //auxiliar[0] = reversed[1] -> 2 = auxiliar[2]
            //auxiliar[1] = reversed[2] -> 3 = auxiliar[2,3]

            //x = 2 [2,3,1]
            //auxiliar[0] = reversed[1] -> 3 = auxiliar[3]
            //auxiliar[1] = reversed[2] -> 1 = auxiliar[3,1]

            auxiliar.add(reversed[i+1])
        }

        //x = 1
        //auxiliar[2] = reversed[0] -> 1 = auxiliar[2,3,1]

        //x = 2
        //auxiliar[2] = reversed[0] -> 2 = auxiliar[3,1,2]

        auxiliar.add(reversed[0])
        reversed = auxiliar.toTypedArray() //reversed[2,3,1] -> reversed[3,1,2]
    }

    return reversed
}

/**
 * [1,2,3]
 * for -> 0..2
 *
 */

fun rotLeft(a: IntArray, d: Int): IntArray { //BigO(3+3N)
    val rotatedArray = IntArray(a.size) // 1
    var indexOldArray = d % a.size // 1

    //a = 3 | 0/1/2
    for (i in rotatedArray.indices) { //N
        rotatedArray[i] = a[indexOldArray++] //N
        if (indexOldArray >= a.size) { //N
            indexOldArray = 0 //N
        }
    }

    return rotatedArray //1
}

fun main(args: Array<String>) {
    val a = arrayOf(1,2,3)
    val d = 3
    val result = rotLeft(a, d)

    val polindrome = "aabaa"
    val split = polindrome.split("")

    for (i in 0..split.size) {
        println(split[i])
    }

    println(result.joinToString(" "))
}