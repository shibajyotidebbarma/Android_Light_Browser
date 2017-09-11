package com.example.shibajyotidebbarma.lightbrowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by shiv on 11-09-2017.
 */

class ourViewClient extends WebViewClient {

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      view.loadUrl(url);
        return true;
    }
}
