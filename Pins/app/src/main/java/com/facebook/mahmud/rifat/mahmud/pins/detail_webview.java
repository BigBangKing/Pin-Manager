
package com.facebook.mahmud.rifat.mahmud.pins;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class detail_webview extends AppCompatActivity {

    String s, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_webview);
        WebView webview = new WebView(this);
        webview = (WebView) findViewById(R.id.webview);
        Button button = (Button) findViewById(R.id.button2);
        if (webview != null) {
            webview.setWebChromeClient(new WebChromeClient());

            webview.getSettings().setBuiltInZoomControls(true);

            webview.getSettings().setDisplayZoomControls(true);
            webview.canGoBack();
            webview.canGoForward();
//        webview.getSettings().setBuiltInZoomControls(true);
            webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
/*
            webview.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return super.shouldOverrideUrlLoading(view, url);
                }
            });
*/

            webview.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        WebView webView = (WebView) v;

                        switch (keyCode) {
                            case KeyEvent.KEYCODE_BACK:
                                if (webView.canGoBack()) {
                                    webView.goBack();
                                    return true;
                                }
                                break;
                        }
                    }

                    return false;
                }
            });
        }
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null) {
            s = b.getString("url");
            t = b.getString("per");
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    trans(v);

                    finish();
                }
            });
        }


        if (webview != null) {
            webview.loadUrl(s);
        }


    }


    private void trans(View v) {

        Uri uri = Uri.parse(t);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        v.getContext().startActivity(intent);

    }
}
