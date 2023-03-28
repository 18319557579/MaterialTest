package com.hsf.materialtest

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(text: String, actionText: String? = "sddf", duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, text, duration)
    if (actionText != null && block != null) {
        snackbar.setAction(actionText) {
            block()
        }
    }
    snackbar.show()
}