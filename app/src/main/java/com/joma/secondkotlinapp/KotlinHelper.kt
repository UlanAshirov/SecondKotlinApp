package com.joma.secondkotlinapp.ui

import com.squareup.picasso.Picasso
import android.content.Context
import android.widget.ImageView
import android.widget.Toast



fun ImageView.loadUrl(url: String?) {
    Picasso.get().load(url).into(this)
}

fun Context.getToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}