package br.com.jonathanarodr.challenges.leetcode

import br.com.jonathanarodr.util.AssertEquals.equalsTo
import java.util.Stack

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']'
 * determine if the input string is valid.
 */
private fun isValidParentheses(s: String): Boolean {
    val stack = Stack<Char>()

    s.forEach { char ->
        when (char) {
            '(' -> stack.push(')')
            '[' -> stack.push(']')
            '{' -> stack.push('}')
            ')', ']', '}' -> {
                if (stack.isEmpty() || stack.pop() != char) {
                    return false
                }
            }
        }
    }

    return stack.isEmpty()
}

fun main() {
    val input = "a{b(c)d}e"

    val result = isValidParentheses(s = input)

    result equalsTo true
}
