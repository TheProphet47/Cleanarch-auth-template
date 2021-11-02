package com.freesia.homeownersnotices.core.platform

import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.freesia.homeownersnotices.R
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Failure
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment(@LayoutRes private val layoutId: Int) : Fragment(layoutId) {

    protected fun handleFailure(failure: Failure?) {
        when (failure) {
            Failure.NetworkConnection -> notify(R.string.message_no_internet_connection)
            Failure.ServerError -> notify(R.string.message_something_went_wrong)
            Failure.TokenFullyExpired -> notify(R.string.message_token_fully_expired)
            Failure.Unauthorized -> notify(R.string.message_unable_do_unauthorized)
            else -> notify(R.string.message_something_went_wrong)
        }
    }

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected fun notify(@StringRes message: Int) =
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()

}