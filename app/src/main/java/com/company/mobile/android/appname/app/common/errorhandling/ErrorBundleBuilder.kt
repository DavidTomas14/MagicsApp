package com.company.mobile.android.appname.app.common.errorhandling

import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.model.exception.HTTPException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException


abstract class ErrorBundleBuilder {

    abstract fun build(throwable: Throwable, appAction: AppAction): ErrorBundle

    open fun generateAppError(t: Throwable): AppError {
        return when (t) {
            is UnknownHostException -> AppError.NO_INTERNET
            is TimeoutException -> AppError.TIMEOUT
            else -> AppError.UNKNOWN
        }
    }

    open fun generateStringId(t: Throwable, appAction: AppAction): Int {
        return when (t) {
            is UnknownHostException -> R.string.error_no_connection
            is TimeoutException -> R.string.error_connection_timeout
            else -> handleAppAction(appAction, t)
        }
    }

    abstract fun handleAppAction(appAction: AppAction, t: Throwable): Int

    open fun generateMessage(t: Throwable): String {
        return t.message?.let {
            if (it.isNotEmpty()) it
            else "There was an application error"
        } ?: "There was an application error"
    }
}