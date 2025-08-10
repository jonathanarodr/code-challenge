package challenges.tests
//
//data class Transaction(
//    val payee: String,
//    val amount: Int,
//    val payer: String,
//)
//
//fun getTransactions() = listOf(
//    Transaction("BoA", 132, "Chase"),
//    Transaction("BoA", 827, "Chase"),
//    Transaction("Wells Fargo", 751, "BoA"),
//    Transaction("BoA", 585, "Chase"),
//    Transaction("Chase", 877, "Wells Fargo"),
//    Transaction("Wells Fargo", 157, "Chase"),
//    Transaction("Wells Fargo", 904, "Chase"),
//    Transaction("Chase", 548, "Wells Fargo"),
//    Transaction("Chase", 976, "BoA"),
//    Transaction("BoA", 872, "Wells Fargo"),
//    Transaction("Wells Fargo", 571, "Chase"),
//)
//
//fun main() {
//    val transactions = getTransactions()
//    val batch = mutableMapOf<String, Transaction>()
//
//    transactions.forEach { transaction ->
//        val key = transaction.payee + transaction.payer
//
//        if (batch.containsKey(key)) {
//            val amount = (batch[key]?.amount ?: 0) + transaction.amount
//            batch[key] = transaction.copy(amount = amount)
//        } else {
//            batch[key] = transaction
//        }
//    }
//
//    println("Print batch...")
//    batch.values.forEach { println(it) }
//}

/**
 * Given a set of transactions with payee, payer and payment amount
 * calculate the number of transactions if the payee or payer is the same and return a new list of transactions
 * containing the sum of the transaction amounts
 *
 * I.e.,
 *      Transaction1: { "BoA", 100, "Chase" }
 *      Transaction2: { "Chase", 140, "BoA" }
 *      BashTransaction: { "Chase", "BoA", 240 }
 */

private data class Transaction(
    val payer: String,
    val payee: String,
    val amount: Int,
)

private data class TransactionBash(
    val identifier: String,
    val amount: Int,
)

private fun calculateTransactions() {

}

fun main() {
    val transactions = listOf(
        Transaction("", "", 100),
    )
}
