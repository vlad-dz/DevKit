package ru.vladdz.devkit.core.logger

interface Loggable {
    fun v(msg: String)
    fun v(tr: Throwable?)
    fun v(msg: String, tr: Throwable?)

    fun d(msg: String)
    fun d(tr: Throwable?)
    fun d(msg: String, tr: Throwable?)

    fun i(msg: String)
    fun i(tr: Throwable?)
    fun i(msg: String, tr: Throwable?)

    fun w(msg: String)
    fun w(tr: Throwable?)
    fun w(msg: String, tr: Throwable?)

    fun e(msg: String)
    fun e(tr: Throwable?)
    fun e(msg: String, tr: Throwable?)

    fun println(priority: Int, tag: String, msg: String)
}