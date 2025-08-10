package challenge

private fun quickSort(vetor: IntArray, inicio: Int, fim: Int) {
    if (inicio < fim) {
        val posicaoPivo = separar(vetor, inicio, fim)
        quickSort(vetor, inicio, posicaoPivo - 1)
        quickSort(vetor, posicaoPivo + 1, fim)
    }
}

private fun separar(vetor: IntArray, inicio: Int, fim: Int): Int {
    val pivo = vetor[inicio]
    var i = inicio + 1
    var f = fim
    while (i <= f) {
        if (vetor[i] <= pivo) i++ else if (pivo < vetor[f]) f-- else {
            val troca = vetor[i]
            vetor[i] = vetor[f]
            vetor[f] = troca
            i++
            f--
        }
    }
    vetor[inicio] = vetor[f]
    vetor[f] = pivo
    return f
}

private fun orderSquareList(input: IntArray): IntArray {
    val squareList = IntArray(input.size)

    for (item in input.withIndex()) {
        squareList[item.index] = item.value * item.value
    }

    val pivot = squareList.size / 2
    println(pivot)
    return squareList
}

fun main() {
    val input = intArrayOf(-3, -1, 0, 5, 8)
    val result = orderSquareList(input)

    println("Result is ${result.joinToString()}")
}