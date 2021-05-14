package ru.vladdz.devkit.core.logger

object Log {
    object v: Logger(VERBOSE)
    object d: Logger(DEBUG)
    object i: Logger(INFO)
    object w: Logger(WARN)
    object e: Logger(ERROR)

    private var logger: Loggable? = null

    fun setup(logger: Loggable) {
        this.logger = logger
    }

    fun getLogger(): Loggable? {
        return logger
    }
}