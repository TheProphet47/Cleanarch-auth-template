package com.freesia.homeownersnotices.core.extension

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

fun Boolean?.toNullableInt() = when(this) {
    true -> 1
    false -> 2
    null -> null
}

inline fun <To, From> From.mapWith(mapper: (From) -> To): To {
    return mapper(this)
}

inline fun <To, From> List<From>.mapListWith(mapSingle: (From) -> To): List<To> {
    return this.map { mapSingle(it) }
}

suspend fun <A, B> Iterable<A>.pmap(f: suspend (A) -> B): List<B> = coroutineScope {
    map { async { f(it) } }.awaitAll()
}