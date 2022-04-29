package com.company.mobile.android.appname.app.common.util

import android.text.InputType
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.EditText
import androidx.core.view.children

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invalidateViewVisibility() {
    this.visibility = if (this.visibility == View.VISIBLE) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

fun View.enable() {
    this.isEnabled = true
}

fun View.disable() {
    this.isEnabled = false
}

fun ViewGroup.activateChildren() {
    children.forEach { child ->
        when (child) {
            is AdapterView<*> -> child.setOnTouchListener(null)
            is ViewGroup -> {
                child.activateChildren()
            }
            else -> {
                child.setOnTouchListener(null)
            }
        }
    }
}

fun ViewGroup.desactivateChildren(childrenNotDesactivated: List<Int> = emptyList()) {
    children.filterNot { it.id in childrenNotDesactivated }.forEach { child ->
        when (child) {
            is AdapterView<*> -> {
                // It is better to override onTouchListener. Disabling views change their colors
                child.setOnTouchListener { _, _ ->
                    true
                }
            }
            is EditText -> {
                child.inputType = InputType.TYPE_NULL
            }
            is ViewGroup -> {
                child.setOnClickListener { }
                child.desactivateChildren(childrenNotDesactivated)
            }
            else -> {
                child.setOnClickListener { }
            }
        }
    }
}