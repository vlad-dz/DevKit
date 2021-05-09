package ru.vladdz.devkit.core.logger

val Any.TAG: String
    get() {
        var name = this.javaClass.simpleName
        if (name == "") name = this.javaClass.name
        if (name == "") name = "TAG"
        return name
    }