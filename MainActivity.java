package com.ayyanarsweets.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        WebView w = new WebView(this);
        w.setWebViewClient(new WebViewClient(){
            @Override public boolean shouldOverrideUrlLoading(WebView view, String url){
                if(url.startsWith("https://wa.me/") || url.startsWith("tel:") || url.startsWith("geo:")) {
                    try { startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url))); } catch(Exception ignored) {}
                    return true;
                }
                return false;
            }
        });
        WebSettings s=w.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setAllowFileAccess(true);
        w.loadUrl("file:///android_asset/index.html"); setContentView(w);
    }
    @Override public void onBackPressed(){
        WebView w=(WebView)findViewById(android.R.id.content); super.onBackPressed();
    }
}
