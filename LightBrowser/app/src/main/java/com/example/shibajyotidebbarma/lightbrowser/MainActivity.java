package com.example.shibajyotidebbarma.lightbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView brow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brow = (WebView) findViewById(R.id.webView_brow);
        String url ="http://hackstories.com";

        brow.loadUrl(url);



    }
}
