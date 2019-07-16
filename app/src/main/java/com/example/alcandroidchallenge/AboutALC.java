package com.example.alcandroidchallenge;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import org.w3c.dom.Text;

public class AboutALC extends AppCompatActivity {
    WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ProgressBar progressBar= (ProgressBar) findViewById(R.id.progress_bar);
        WebView webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings();




        webView.setWebViewClient(new WebViewClient() {




            @Override
            public boolean shouldOverrideUrlLoading (WebView view,String url){
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onReceivedSslError (WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int progress){
                progressBar.setProgress(progress);
                if(progress == 100){
                    progressBar.setVisibility(View.INVISIBLE);
                }
                else {

                    progressBar.setVisibility(View.VISIBLE);

                }
            }
        });



        webView.loadUrl("https://andela.com/alc/");
    }

}