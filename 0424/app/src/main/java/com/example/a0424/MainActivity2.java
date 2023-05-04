package com.example.a0424;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity2 extends AppCompatActivity {

    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        WebView wv=(WebView) findViewById(R.id.webview);
        //縮放功能
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.invokeZoomPicker();
        
        wv.loadUrl("http://www.cgu.edu.tw");

    }
}