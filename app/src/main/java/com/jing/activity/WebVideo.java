package com.jing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class WebVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_video);
        WebView webView = (WebView) findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this,"js");

//        webView.loadUrl("http://www.baidu.com");
        webView.loadUrl("file:///android_asset/index.html");

    }
    @JavascriptInterface
    private  void getUrl(String url){
        Toast.makeText(this,"地址"+url,Toast.LENGTH_LONG).show();
    }
}
