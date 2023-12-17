package com.example.rkmvcstudentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class HomeWebActivity extends AppCompatActivity {

    WebView web;

    public String url="https://aims.rkmvc.ac.in/student/loginPage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeweb);
        web=findViewById(R.id.webView);
        WebSettings webSettings=web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new MyWebViewClient());
        web.loadUrl(url);
    }

    @Override
    public void onBackPressed(){
        if(web.canGoBack()){
            web.goBack();
        }else {
            super.onBackPressed();
        }
    }

    static class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }

    public void open(View view){
        Intent intent = new Intent(HomeWebActivity.this, CalculatorActivity.class);
        startActivity(intent);
    }
}