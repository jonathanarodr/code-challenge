package br.com.jonathan.util

private const val GreenColor = "\u001B[32m"
private const val RedColor = "\u001B[31m"
private const val Reset = "\u001B[0m"
private const val FontBold = "\u001B[1m"

object AssertEquals {

    infix fun Any?.equalsTo(expected: Any) {
        if (this != expected) {
            println("$FontBold$RedColor[✖]$Reset Failure\n")
            error(
                "Result value is not the same as expected\n" +
                "Result:   $this\n" +
                "Expected: $expected"
            )
        } else {
            println("\n$FontBold$GreenColor[✓]$Reset Successful")
        }
    }
}
