package com.mustafaunlu.autobiographyapp.ui.blogs

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.mustafaunlu.autobiographyapp.R
import com.mustafaunlu.autobiographyapp.databinding.FragmentBlogsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlogsFragment : Fragment() {
    private lateinit var binding: FragmentBlogsBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBlogsBinding.inflate(inflater, container, false)
        val blogWebViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.blogsWebview.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                binding.blogsWebview.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }
        }
        binding.blogsWebview.apply {
            webViewClient = blogWebViewClient
            settings.javaScriptEnabled = true
            loadUrl(getString(R.string.medium_blog_url))
        }
        return binding.root
    }
}
