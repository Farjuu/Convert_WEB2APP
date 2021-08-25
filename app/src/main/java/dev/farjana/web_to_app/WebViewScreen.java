package dev.farjana.web_to_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewScreen extends AppCompatActivity {


    private  WebView webView;
    WebSettings webSettings;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_screen);


         Intent receiverIntent = getIntent();
         String searchUrl = receiverIntent.getStringExtra("urlText");
         webView = findViewById(R.id.webview);
         webSettings =  webView.getSettings();
         webView.loadUrl(searchUrl);
         webView.setWebViewClient(new WebViewController());
         webSettings.setJavaScriptEnabled(true);

    }

    public static class WebViewController extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }


    }
}