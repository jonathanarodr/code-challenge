package challenge

private fun sortByInsertion(input: IntArray) {
    //todo
}

private fun sortBySelection(input: IntArray) {
    //todo
}

private fun sortByBubbleSort(input: IntArray) {
//    for (value in 0..input.lastIndex downTo 2) {
//
//    }
//
//    for ((i, j) in (inputSplit.lastIndex downTo 0).withIndex()) {
//
//    }
}

fun quicksort(items:List<Int>):List<Int>{
    if (items.count() < 2){
        return items
    }
    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }
    println("pivot value is : $equal")

    val less = items.filter { it < pivot }
    println("Lesser values than pivot : $less")

    val greater = items.filter { it > pivot }
    println("Greater values than pivot : $greater")

    return quicksort(less) + equal + quicksort(greater)
}
fun main(args: Array<String>) {
    println(" Original list:")
    val numbers = listOf<Int>(2, 4, 7, 3, 6, 9, 5, 1, 0)
    println(numbers)
    println(" Ordered list:")
    val ordered =  quicksort(numbers)
    println(ordered)
}