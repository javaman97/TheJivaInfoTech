package com.example.thejivainfotech

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
     lateinit var webView:WebView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView=findViewById(R.id.webView)

        webviewSetup(webView)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webviewSetup(webView: WebView) {
        webView.webViewClient= WebViewClient()
        webView.apply {
           webView.addJavascriptInterface(WebAppInterface(this@MainActivity), "Android")
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
            loadUrl("https://thejivainfotech.com/")
        }
    }
}