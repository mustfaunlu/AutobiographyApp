package com.mustafaunlu.autobiographyapp.ui.blogs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mustafaunlu.autobiographyapp.databinding.FragmentBlogsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlogsFragment : Fragment() {

    private lateinit var viewModel: BlogsViewModel
    lateinit var binding: FragmentBlogsBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBlogsBinding.inflate(inflater, container, false)
        binding.blogsWebview.apply {
            settings.javaScriptEnabled = true
            loadUrl(BLOG_URL)
        }
        return binding.root
    }

    companion object {
        const val BLOG_URL = "https://mustafaunlu.medium.com/"
    }
}
