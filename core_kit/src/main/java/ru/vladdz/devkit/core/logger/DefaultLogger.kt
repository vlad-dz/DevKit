package ru.vladdz.devkit.core.logger

import java.util.logging.Logger

class DefaultLogger private constructor(): Loggable {

    override fun println(priority: Int, tag: String, msg: String) {
        val logger = getLogger(tag)

        when(priority) {
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

    companion object {
        private var instance: DefaultLogger? = null

        fun getInstance(): DefaultLogger {
            return instance ?: synchronized(this) {
                instance ?: DefaultLogger().also {
                    instance = it
                }
            }
        }
    }

}