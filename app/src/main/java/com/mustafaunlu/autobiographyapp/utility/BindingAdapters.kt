package com.mustafaunlu.autobiographyapp.utility

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mustafaunlu.autobiographyapp.R
import com.mustafaunlu.autobiographyapp.ui.home.ProgressBarState

@BindingAdapter("progressBarState")
fun bindStatus(progressBar: ImageView, status: ProgressBarState?) {
    when (status) {
        ProgressBarState.SUCCESS -> {
            progressBar.visibility = View.GONE
        }
        ProgressBarState.LOADING -> {
            progressBar.visibility = View.VISIBLE
            progressBar.setImageResource(R.drawable.progressbar_animation)
        }
        ProgressBarState.ERROR -> {
            progressBar.visibility = View.VISIBLE
            progressBar.setImageResource(R.drawable.ic_connection_error)
        }
        else -> {}
    }
}
