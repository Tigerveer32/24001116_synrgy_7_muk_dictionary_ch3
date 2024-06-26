package com.example.a24001116_synrgy_7_muk_dictionary_ch3.presentation.google

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.R
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.common.doMaterialMotion
import com.example.a24001116_synrgy_7_muk_dictionary_ch3.databinding.FragmentGoogleBinding


class GoogleFragment : Fragment(), OnClickListener {

    private var _binding: FragmentGoogleBinding? = null
    private val binding get() = _binding!!
    private val args: GoogleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGoogleBinding.inflate(inflater, container, false)
        binding.cardView.transitionName = args.word
        doMaterialMotion(binding.cardView, args.word ?: "")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView()
    }

    private fun bindView() {
        binding.cardView.setOnClickListener(this)

        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.useWideViewPort = true
        binding.webView.loadUrl(getString(R.string.intent_to_weburl)+args.word)
        binding.webView.webChromeClient = chromeProgressBar

        requireActivity().onBackPressedDispatcher.addCallback(onBackPressedCallback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.webView.stopLoading()
        binding.webView.destroy()
        _binding = null
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            when {
                binding.webView.canGoBack() -> binding.webView.goBack()
                else -> findNavController().navigateUp()
            }
        }
    }

    private val chromeProgressBar = object : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            if (newProgress == 100) {
                binding.progressBar.isVisible = false
            }
            if (newProgress < 100) {
                binding.progressBar.isVisible = true
                binding.progressBar.progress = newProgress
            }
        }
    }

    override fun onClick(p0: View?) {
        when {
            binding.webView.canGoBack() -> binding.webView.goBack()
            else -> findNavController().navigateUp()
        }
    }
}