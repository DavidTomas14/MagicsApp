package com.company.mobile.android.appname.app.common.errorhandling

import timber.log.Timber
import java.io.Serializable

interface ErrorDialogFragmentListener : Serializable {

    fun onErrorDialogAccepted(action: Long, retry: Boolean) {
        Timber.d("User accepted: action = $action and retry value is $retry")
    }

    fun onErrorDialogCancelled(action: Long) {
        Timber.d("User cancelled error dialog")
    }
}