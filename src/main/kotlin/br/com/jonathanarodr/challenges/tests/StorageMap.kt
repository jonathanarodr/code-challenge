package br.com.jonathanarodr.challenges.tests

import br.com.jonathanarodr.util.AssertEquals.equalsTo

/**
 * Create a storage library with operations to save, delete and get values in memory, furthermore add a logic to get
 * random value
 */
private class Storage {

    private val data: HashMap<String, Any> = hashMapOf()

    fun save(key: String, value: Any) {
        data[key] = value
    }

    fun delete(key: String): Boolean {
        return if (data.containsKey(key)) {
            data.remove(key)
            true
        } else {
            false
        }
    }

    fun get(key: String): Any? {
        return data[key]
    }

    fun randomValue(): Any? {
        return data.toList().randomOrNull()
    }
}

fun main() {
    val storage = Storage()
    val data = "fruit" to "apple"

    storage.save(data.first, data.second)
    val result = storage.get(data.first)

    result equalsTo data.second
}
