package ru.vladdz.devkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.vladdz.devkit.core.logger.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.setupLogger(object: LogTree() {
            override fun println(priority: Int, tag: String, msg: String) {
                when (priority) {
                    VERBOSE -> android.util.Log.v(tag, msg)
                    DEBUG -> android.util.Log.d(tag, msg)
                    INFO -> android.util.Log.i(tag, msg)
                    WARN -> android.util.Log.w(tag, msg)
                    ERROR -> android.util.Log.e(tag, msg)
                }
            }
        })

        val exception = IllegalArgumentException("Error")

        d("Caused", exception)
        d(exception)
        tag("CustomTag").d("it is DEBUG")

        v("it is VERBOSE")
        d("it is DEBUG")
        i("it is INFO")
        w("it is WARNING")
        e("it is ERROR")
    }
}