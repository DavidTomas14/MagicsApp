package com.company.mobile.android.appname.app.card

import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.app.common.errorhandling.AppAction
import com.company.mobile.android.appname.app.common.errorhandling.ErrorBundle
import com.company.mobile.android.appname.app.common.errorhandling.ErrorBundleBuilder
import timber.log.Timber

class CardsErrorBundleBuilder : ErrorBundleBuilder() {
    override fun build(throwable: Throwable, appAction: AppAction): ErrorBundle {
        // Unwrap RuntimeExceptions, wrapped by emitter.tryOnError()
        val t = if (throwable is RuntimeException && throwable.cause != null && throwable.cause is Exception) throwable.cause as Exception else throwable
        return ErrorBundle(t, generateStringId(t, appAction), generateMessage(t), appAction, generateAppError(t))
    }

    override fun handleAppAction(appAction: AppAction, t: Throwable): Int {
        return when (appAction) {
            AppAction.GET_CARDS ->
                R.string.error_fetch_cards
            else -> {
                Timber.e("Action \'%s\' not supported", appAction)
                R.string.error_default_message
            }
        }
    }
}