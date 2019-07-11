package com.cynobit.alc40_phase1;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALCActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        // Back Arrow on Action Bar.
        if (getActionBar() != null) getActionBar().setDisplayHomeAsUpEnabled(true);

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();

        // For HTTPS Pages to load HTTP Resources as well.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode( WebSettings.MIXED_CONTENT_ALWAYS_ALLOW );
        }

        // The top part oft the page is powered by JavaScript.
        webSettings.setJavaScriptEnabled(true);

        // Customize the WebView's Behaviour.
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                // Some devices can't verify the site's SSL Certificate so we ignore such problems here.
                handler.proceed();
            }
        });

        // Finally, Load Web Page.
        webView.loadUrl("https://andela.com/alc/");
    }

    @Override
    public void onBackPressed() {
        // In case we navigated deeper into the web page.
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
