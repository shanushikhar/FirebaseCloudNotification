package com.bang.firebasecloudnotification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView textView ;
    private WebView mywebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_main);
        //textView = findViewById(R.id.textView1);
        //textView.setText("Welcome to the Result Activity");

        // changed linear layout to reltive layout and it worked

        // to remove the upper action bar then change
         // go to app -> res -> values -> styles.xml
        // and thn change  <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">

        mywebView =  findViewById(R.id.webview);

        WebSettings webSettings= mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.loadUrl("https://office.kdssoftwares.online/");
        // Line of Code for opening links in app
        mywebView.setWebViewClient(new WebViewClient());
    }

    //Code For Back Button
    @Override
    public void onBackPressed() {
        if(mywebView.canGoBack())
        {
            mywebView.goBack();
        }

        else
        {
            super.onBackPressed();
        }


    }
}
