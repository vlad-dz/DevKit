package ru.vladdz.devkit.core.logger

import java.util.regex.Matcher
import java.util.regex.Pattern

object Tag {

    private val anonymousClassPattern: Pattern = Pattern.compile("(\\$\\d+)+$")
    private const val unknownTag = "UnknownTag"

    fun generateTag(index: Int): String {
        return try {
            var tag = Throwable().stackTrace[index].className

            val m: Matcher = anonymousClassPattern.matcher(tag)
            if (m.find()) tag = m.replaceAll("")

            tag.substringAfterLast('.')
        } catch (ex: IndexOutOfBoundsException) {
            unknownTag
        }
    }
}