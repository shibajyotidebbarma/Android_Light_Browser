package com.example.shibajyotidebbarma.lightbrowser;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView brow;
    EditText urlEdit;
    Button btnGo, btnForward, btnBackward, btnClear, btnReload;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brow = (WebView) findViewById(R.id.webView_brow);
        urlEdit =(EditText) findViewById(R.id.editText_url);
        btnBackward=(Button) findViewById(R.id.btn_backward);
        btnForward=(Button) findViewById(R.id.btn_forward);
        btnGo=(Button) findViewById(R.id.btn_go);
        btnClear=(Button) findViewById(R.id.btn_clear);
        btnReload=(Button) findViewById(R.id.btn_reload);
        progressBar =(ProgressBar) findViewById(R.id.progress_bar);



        brow.setWebViewClient(new ourViewClient());
        brow.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressBar.setProgress(newProgress);



                if(newProgress ==100){

                    progressBar.setVisibility(View.GONE);

                }

                else{

                    progressBar.setVisibility(View.VISIBLE);



                }
            }
        });


        WebSettings webSettings = brow.getSettings();
        webSettings.setJavaScriptEnabled(true);

        brow.loadUrl("http://google.com");

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextValue = urlEdit.getText().toString();


                if(!editTextValue.startsWith("http://")){

                    editTextValue = "http://"+ editTextValue;

                }



                brow.loadUrl(editTextValue);

                InputMethodManager inm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inm.hideSoftInputFromInputMethod(urlEdit.getWindowToken(),0);




            }
        });



        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        btnBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(brow.canGoBack()){

                    brow.goBack();

                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                brow.clearHistory();

            }
        });


        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                brow.reload();

            }
        });









    }
}
