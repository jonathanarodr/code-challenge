package challenges.leetcode

import br.com.jonathan.util.AssertEquals.equalsTo
import java.util.*

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
            else -> {
                if (stack.isEmpty() || stack.pop() != char) {
                    return false
                }
            }
        }
    }

    return stack.isEmpty()
}

fun main() {
    val input = "[]([{}])()"

    val result = isValidParentheses(s = input)

    result equalsTo true
}
