package ru.vladdz.devkit.core.logger

interface Loggable {
    fun println(priority: Int, tag: String, msg: String)
}