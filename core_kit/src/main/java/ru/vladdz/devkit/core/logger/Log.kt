package ru.vladdz.devkit.core.logger

object Log: Loggable {

    private var logger: LogTree = DefaultLogger

    fun setupLogger(logger: LogTree) {
        this.logger = logger
    }

    fun tag(tag: String): LogTree {
        return logger.tag(tag)
    }

    override fun v(msg: String) = logger.v(msg)

    override fun v(tr: Throwable?) = logger.v(tr)

    override fun v(msg: String, tr: Throwable?) = logger.v(msg, tr)

    override fun d(msg: String) = logger.d(msg)

    override fun d(tr: Throwable?) = logger.d(tr)

    override fun d(msg: String, tr: Throwable?) = logger.d(msg, tr)

    override fun i(msg: String) = logger.i(msg)

    override fun i(tr: Throwable?) = logger.i(tr)

    override fun i(msg: String, tr: Throwable?) = logger.i(msg, tr)

    override fun w(msg: String) = logger.w(msg)

    override fun w(tr: Throwable?) = logger.w(tr)

    override fun w(msg: String, tr: Throwable?) = logger.w(msg, tr)

    override fun e(msg: String) = logger.e(msg)

    override fun e(tr: Throwable?) = logger.e(tr)

    override fun e(msg: String, tr: Throwable?) = logger.e(msg, tr)

    override fun println(priority: Int, tag: String, msg: String) {
        logger.println(priority, tag, msg)
    }
}