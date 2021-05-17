package ru.vladdz.devkit.core.logger


fun tag(tag: String): LogTree {
    return Log.tag(tag)
}

private fun generateTag(): String {
    return Tag.generateTag(3)
}

// VERBOSE
fun v(msg: String) {
    tag(generateTag()).v(msg)
}

fun v(tr: Throwable?) {
    tag(generateTag()).v(tr)
}

fun v(msg: String, tr: Throwable?) {
    tag(generateTag()).v(msg, tr)
}

// DEBUG
fun d(msg: String) {
    tag(generateTag()).d(msg)
}

fun d(tr: Throwable?) {
    tag(generateTag()).d(tr)
}

fun d(msg: String, tr: Throwable?) {
    tag(generateTag()).d(msg, tr)
}

// INFO
fun i(msg: String) {
    tag(generateTag()).i(msg)
}

fun i(tr: Throwable?) {
    tag(generateTag()).i(tr)
}

fun i(msg: String, tr: Throwable?) {
    tag(generateTag()).i(msg, tr)
}

// WARN
fun w(msg: String) {
    tag(generateTag()).w(msg)
}

fun w(tr: Throwable?) {
    tag(generateTag()).w(tr)
}

fun w(msg: String, tr: Throwable?) {
    tag(generateTag()).w(msg, tr)
}

// ERROR
fun e(msg: String) {
    tag(generateTag()).e(msg)
}

fun e(tr: Throwable?) {
    tag(generateTag()).e(tr)
}

fun e(msg: String, tr: Throwable?) {
    tag(generateTag()).e(msg, tr)
}