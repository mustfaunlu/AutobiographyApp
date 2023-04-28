package com.mustafaunlu.autobiographyapp.ui.blogs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.blogsWebview.apply {
            settings.javaScriptEnabled = true
            loadUrl(getString(R.string.medium_blog_url))
        }
        return binding.root
    }
}
