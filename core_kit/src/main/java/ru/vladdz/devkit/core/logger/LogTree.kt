package ru.vladdz.devkit.core.logger

import java.io.PrintWriter
import java.io.StringWriter
import java.net.UnknownHostException

abstract class LogTree : Loggable {
    private val threadLocal = ThreadLocal<String>()

    fun tag(tag: String): LogTree {
        threadLocal.set(tag)
        return this
    }

    private fun getTag(): String {
        return threadLocal.get().also {
            threadLocal.remove()
        } ?: Tag.generateTag(4)
    }

    override fun v(msg: String) {
        println(VERBOSE, getTag(), msg)
    }

    override fun v(tr: Throwable?) {
        println(VERBOSE, getTag(), getStackTraceString(tr))
    }

    override fun v(msg: String, tr: Throwable?) {
        println(VERBOSE, getTag(), getMsgWithStacktrace(msg, tr))
    }

    override fun d(msg: String) {
        println(DEBUG, getTag(), msg)
    }

    override fun d(tr: Throwable?) {
        println(DEBUG, getTag(), getStackTraceString(tr))
    }

    override fun d(msg: String, tr: Throwable?) {
        println(DEBUG, getTag(), getMsgWithStacktrace(msg, tr))
    }

    override fun i(msg: String) {
        println(INFO, getTag(), msg)
    }

    override fun i(tr: Throwable?) {
        println(INFO, getTag(), getStackTraceString(tr))
    }

    override fun i(msg: String, tr: Throwable?) {
        println(INFO, getTag(), getMsgWithStacktrace(msg, tr))
    }

    override fun w(msg: String) {
        println(WARN, getTag(), msg)
    }

    override fun w(tr: Throwable?) {
        println(WARN, getTag(), getStackTraceString(tr))
    }

    override fun w(msg: String, tr: Throwable?) {
        println(WARN, getTag(), getMsgWithStacktrace(msg, tr))
    }

    override fun e(msg: String) {
        println(ERROR, getTag(), msg)
    }

    override fun e(tr: Throwable?) {
        println(ERROR, getTag(), getStackTraceString(tr))
    }

    override fun e(msg: String, tr: Throwable?) {
        println(ERROR, getTag(), getMsgWithStacktrace(msg, tr))
    }

    private fun getMsgWithStacktrace(msg: String, tr: Throwable?): String {
        return msg + '\n' + getStackTraceString(tr)
    }

    /**
     * Handy function to get a loggable stack trace from a Throwable
     * @param tr An exception to log
     */
    private fun getStackTraceString(tr: Throwable?): String {
        if (tr == null) {
            return ""
        }

        // This is to reduce the amount of log spew that apps do in the non-error
        // condition of the network being unavailable.
        var t = tr
        while (t != null) {
            if (t is UnknownHostException) {
                return ""
            }
            t = t.cause
        }
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        tr.printStackTrace(pw)
        pw.flush()
        return sw.toString()
    }
}