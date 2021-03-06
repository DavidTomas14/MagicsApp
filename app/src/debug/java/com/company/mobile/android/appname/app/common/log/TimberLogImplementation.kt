package com.company.mobile.android.appname.app.common.log

import com.company.mobile.android.appname.app.TimberLog
import timber.log.Timber

object TimberLogImplementation : TimberLog {

    override fun init(userId: String) {
        init()
    }

    override fun init() {
        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String {
                return String.format(
                    "%s::%s:%s",
                    super.createStackElementTag(element),
                    element.methodName,
                    element.lineNumber
                )
            }
        })
    }
}
