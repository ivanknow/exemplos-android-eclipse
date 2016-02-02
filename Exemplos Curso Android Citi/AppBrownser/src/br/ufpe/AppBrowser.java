package br.ufpe;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AppBrowser extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        WebView w = new WebView(this);
        WebSettings ws = w.getSettings();
        w.loadUrl("http://www.google.com");
        setContentView(w);
    }
}