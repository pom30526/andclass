package kr.co.company.webapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebAppActivity extends ActionBarActivity {

        private EditText field;
        private WebView webview;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            field = (EditText)findViewById(R.id.url);
            webview = (WebView)findViewById(R.id.webView);
            webview.setWebViewClient(new TestBrowser());
        }


        public void open(View view){
            String url = field.getText().toString();
            webview.getSettings().setLoadsImagesAutomatically(true);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webview.loadUrl(url);

        }
        private class TestBrowser extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        }

    }
