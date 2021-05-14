package ru.vladdz.devkit.core.logger

import java.io.PrintWriter
import java.io.StringWriter
import java.net.UnknownHostException

abstract class Logger(private val priority: Int) {

    operator fun invoke(tag: String, msg: String) {
        Log.getLogger()?.println(priority, tag, msg)
    }

    operator fun invoke(tag: String, tr: Throwable?) {
        invoke(tag, getStackTraceString(tr))
    }

    operator fun invoke(tag: String, msg: String, tr: Throwable?) {
        invoke(tag, getMsgWithStacktrace(msg, tr))
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