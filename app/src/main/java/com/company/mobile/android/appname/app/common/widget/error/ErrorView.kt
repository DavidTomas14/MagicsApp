package com.company.mobile.android.appname.app.common.widget.error

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.app.common.errorhandling.ErrorBundle
import com.company.mobile.android.appname.app.databinding.ViewErrorBinding

import timber.log.Timber

/**
 * Widget used to display an error state to the user
 */
class ErrorView : RelativeLayout {

    lateinit var binding: ViewErrorBinding
    var errorListener: ErrorListener? = null
    var errorBundle: ErrorBundle? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        binding = ViewErrorBinding.inflate(LayoutInflater.from(context), this)
        binding.btErrorViewRetryButton.setOnClickListener {
            errorBundle?.let { errorBundle ->
                errorListener?.apply {
                    onRetry(errorBundle)
                } ?: Timber.e("Error listener is null")
            } ?: Timber.e("Error bundle is null")
        }

        binding.tvErrorViewMessage.text = errorBundle?.let { context.getString(it.stringId) }
    }

    fun setErrorMessage(message: String) {
        // Post a task to update the message
        binding.tvErrorViewMessage.post {
            binding.tvErrorViewMessage.text = message
        }
    }
}