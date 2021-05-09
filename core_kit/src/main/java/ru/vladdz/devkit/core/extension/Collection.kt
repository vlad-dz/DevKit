package ru.vladdz.devkit.core.extension

fun <T> Collection<T>.nullIfEmpty(): Collection<T>? {
    return if(isEmpty()) null
    else this
}

fun <T> Collection<T>?.takeNullSafety(): Collection<T> {
    return this ?: emptyList()
}