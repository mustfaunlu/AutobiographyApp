package com.mustafaunlu.autobiographyapp.utility

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mustafaunlu.autobiographyapp.R
import com.mustafaunlu.autobiographyapp.ui.home.ProgressBarState

/**
 * ProgressBar'in görünürlüğünü değiştirmek için kullanılan databinding ozelligi olan BindingAdapter.
 * BindingAdapter sayesinde [fragment_home.xml] icindeki Imageview'in icine koyulmus progressbar'in gorunurlugunu
 * Viewmodel sinifi uzerinden [app:progressBarState="@{viewModel.progressBarState}"] ile degistirebiliyoruz.
 */
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
