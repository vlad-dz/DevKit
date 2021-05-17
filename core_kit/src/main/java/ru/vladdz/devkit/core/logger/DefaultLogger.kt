package ru.vladdz.devkit.core.logger

import java.util.logging.Logger

object DefaultLogger : LogTree() {
    override fun println(priority: Int, tag: String, msg: String) {
        val logger = getLogger(tag)

        when (priority) {
            VERBOSE -> logger.finest(msg)
            DEBUG -> logger.fine(msg)
            INFO -> logger.info(msg)
            WARN -> logger.warning(msg)
            ERROR -> logger.severe(msg)
        }
    }

    private fun getLogger(tag: String): Logger {
        return Logger.getLogger(tag)
    }
}