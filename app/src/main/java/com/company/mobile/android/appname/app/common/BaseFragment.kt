package com.company.mobile.android.appname.app.common

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import androidx.annotation.CallSuper
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.company.mobile.android.appname.app.R
import com.company.mobile.android.appname.app.common.errorhandling.ErrorBundle
import com.company.mobile.android.appname.app.common.errorhandling.ErrorDialogFragmentListener
import timber.log.Timber

/**
 * Base [Fragment] class for every fragment in this application.
 */
open class BaseFragment : Fragment(), ErrorDialogFragmentListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // At this point, Kotlin extensions are available
        earlyInitializeViews()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initializeState(savedInstanceState)
        initializeViews(savedInstanceState)
        initializeContents(savedInstanceState)
    }

    /**
     * View initialization that does not depend on view models, like setting up a recycler view.
     *
     * Called before [initializeState].
     */
    @CallSuper
    protected open fun earlyInitializeViews() {
    }

    /**
     * Initializes fragment state with [androidx.lifecycle.ViewModel]s and parameters passed through [Bundle].
     *
     * Called before [initializeViews] and after [earlyInitializeViews].
     */
    @CallSuper
    protected open fun initializeState(savedInstanceState: Bundle?) {
    }

    /**
     * View initialization that depends on view models.
     *
     * Called before [initializeContents] and after [initializeState].
     */
    @CallSuper
    protected open fun initializeViews(savedInstanceState: Bundle?) {
    }

    /**
     * Initializes view contents.
     *
     * Called after [initializeViews].
     */
    @CallSuper
    protected open fun initializeContents(savedInstanceState: Bundle?) {
    }

    fun getSafeContext(action: (Context) -> Unit) {
        context?.let {
            action(it)
        }
    }

    fun getSafeActivity(action: (FragmentActivity) -> Unit) {
        activity?.let {
            action(it)
        }
    }

    fun hideKeyBoard() {
        getSafeActivity { activity ->
            activity as BaseActivity
            try {
                (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                    activity.currentFocus?.windowToken,
                    0
                )
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}
