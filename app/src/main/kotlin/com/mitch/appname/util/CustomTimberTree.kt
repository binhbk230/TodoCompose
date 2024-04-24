package com.mitch.appname.util

import timber.log.Timber

class CustomTimberTree: Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String {
        return "${element.fileName}:${element.lineNumber}#${element.methodName}"
    }
}