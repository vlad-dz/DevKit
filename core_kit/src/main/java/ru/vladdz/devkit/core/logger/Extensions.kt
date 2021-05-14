package ru.vladdz.devkit.core.logger

import java.util.regex.Matcher
import java.util.regex.Pattern

var anonymousClassPattern: Pattern = Pattern.compile("(\\$\\d+)+$")

val Any.TAG: String
    get() {
        var tag = Throwable().stackTrace[2].className

        val m: Matcher = anonymousClassPattern.matcher(tag)
        if (m.find()) tag = m.replaceAll("")

        return tag.substringAfterLast('.')

        // deprecated?
        var name = this.javaClass.simpleName
        if (name == "") name = this.javaClass.name
        if (name == "") name = this.toString()
        if (name == "") name = "TAG"
        return name
    }

// VERBOSE
fun Any.v(msg: String) {
    Log.v(TAG, msg)
}

fun Any.v(tr: Throwable?) {
    Log.v(TAG, tr)
}

fun Any.v(tag: String, msg: String) {
    Log.v(TAG, msg)
}

fun Any.v(tag: String, tr: Throwable?) {
    Log.v(TAG, tr)
}

fun Any.v(tag: String, msg: String, tr: Throwable?) {
    Log.v(TAG, msg, tr)
}

// DEBUG
fun Any.d(msg: String) {
    Log.d(TAG, msg)
}

fun Any.d(tr: Throwable?) {
    Log.d(TAG, tr)
}

fun Any.d(tag: String, msg: String) {
    Log.d(TAG, msg)
}

fun Any.d(tag: String, tr: Throwable?) {
    Log.d(TAG, tr)
}

fun Any.d(tag: String, msg: String, tr: Throwable?) {
    Log.d(TAG, msg, tr)
}

// INFO
fun Any.i(msg: String) {
    Log.i(TAG, msg)
}

fun Any.i(tr: Throwable?) {
    Log.i(TAG, tr)
}

fun Any.i(tag: String, msg: String) {
    Log.i(TAG, msg)
}

fun Any.i(tag: String, tr: Throwable?) {
    Log.i(TAG, tr)
}

fun Any.i(tag: String, msg: String, tr: Throwable?) {
    Log.i(TAG, msg, tr)
}


// WARN
fun Any.w(msg: String) {
    Log.w(TAG, msg)
}

fun Any.w(tr: Throwable?) {
    Log.w(TAG, tr)
}

fun Any.w(tag: String, msg: String) {
    Log.w(TAG, msg)
}

fun Any.w(tag: String, tr: Throwable?) {
    Log.w(TAG, tr)
}

fun Any.w(tag: String, msg: String, tr: Throwable?) {
    Log.w(TAG, msg, tr)
}

// ERROR
fun Any.e(msg: String) {
    Log.e(TAG, msg)
}

fun Any.e(tr: Throwable?) {
    Log.e(TAG, tr)
}

fun Any.e(tag: String, msg: String) {
    Log.e(TAG, msg)
}

fun Any.e(tag: String, tr: Throwable?) {
    Log.e(TAG, tr)
}

fun Any.e(tag: String, msg: String, tr: Throwable?) {
    Log.e(TAG, msg, tr)
}

