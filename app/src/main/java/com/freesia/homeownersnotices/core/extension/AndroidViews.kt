package com.freesia.homeownersnotices.core.extension

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.freesia.homeownersnotices.cleanarch.domain.entity.model.Failure


// RecyclerView

fun RecyclerView.setItemDecoration(
    context: Context,
    orientation: Int = DividerItemDecoration.VERTICAL,
    @DrawableRes drawable: Int //= R.drawable.shape_line_horizontal
) {
    ContextCompat.getDrawable(context, drawable)?.let {
        val itemDecoration = DividerItemDecoration(context, orientation)
        itemDecoration.setDrawable(it)
        addItemDecoration(itemDecoration)
    }
}

fun ViewGroup.inflate(@LayoutRes itemLayoutId: Int): View =
    LayoutInflater.from(context).inflate(itemLayoutId, this, false)


// Fragment

fun <T : Any, L : LiveData<T>> Fragment.observe(liveData: L, body: (T?) -> Unit) =
    liveData.observe(viewLifecycleOwner, Observer(body))

fun <L : LiveData<Failure>> Fragment.failure(liveData: L, body: (Failure?) -> Unit) =
    liveData.observe(viewLifecycleOwner, Observer(body))

fun Fragment.showLink(url: String?) {
    val newsIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url ?: ""))
    startActivity(newsIntent)
}
