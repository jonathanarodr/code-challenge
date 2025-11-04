package br.com.jonathanarodr.challenges.tests

/**
 * Given a set of transactions with payee, payer and payment amount
 * calculate the number of transactions if the payee or payer is the same and return a new list of transactions
 * containing the sum of the transaction amounts
 *
 * i.e.
 *      Transaction1: { "BoA", 100, "Chase" }
 *      Transaction2: { "Chase", 140, "BoA" }
 *      BashTransaction: { "Chase", "BoA", 240 }
 */

private data class Transaction(
    val payee: String,
    val payer: String,
    val amount: Int,
)

fun main() {
    val transactions = listOf(
        Transaction(payee = "BoA", payer = "Chase", amount = 132),
        Transaction(payee = "BoA", payer = "Chase", amount = 827),
        Transaction(payee = "Wells Fargo", payer = "BoA", amount = 751),
        Transaction(payee = "BoA", payer = "Chase", amount = 585),
        Transaction(payee = "Chase", payer = "Wells Fargo", amount = 877),
        Transaction(payee = "Wells Fargo", payer = "Chase", amount = 157),
        Transaction(payee = "Wells Fargo", payer = "Chase", amount = 904),
        Transaction(payee = "Chase", payer = "Wells Fargo", amount = 548),
        Transaction(payee = "Chase", payer = "BoA", amount = 976),
        Transaction(payee = "BoA", payer = "Wells Fargo", amount = 872),
        Transaction(payee = "Wells Fargo", payer = "Chase", amount = 571),
    )

    val bashTransactions = mutableMapOf<Pair<String, String>, Int>()

    transactions.forEach { transaction ->
        val payeeToPayer = transaction.payee to transaction.payer
        val payerToPayee = transaction.payer to transaction.payee

        val transactionId = when {
            bashTransactions.contains(payeeToPayer) -> payeeToPayer
            bashTransactions.contains(payerToPayee) -> payerToPayee
            else -> payerToPayee
        }

        bashTransactions[transactionId] = (bashTransactions[transactionId] ?: 0) + transaction.amount
    }

    println("Result: $bashTransactions")
}
