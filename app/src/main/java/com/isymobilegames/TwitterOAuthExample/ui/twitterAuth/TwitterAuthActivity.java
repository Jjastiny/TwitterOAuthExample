package com.isymobilegames.TwitterOAuthExample.ui.twitterAuth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.isymobilegames.TwitterOAuthExample.R;
import com.isymobilegames.TwitterOAuthExample.dagger.ComponentHolder;
import com.isymobilegames.TwitterOAuthExample.ui.MainActivity;
import com.isymobilegames.TwitterOAuthExample.ui.base.BaseDaggerMvpActivity;
import com.isymobilegames.TwitterOAuthExample.util.Preferences;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/** Created by justinyang on 11/15/17. */
public class TwitterAuthActivity
    extends BaseDaggerMvpActivity<TwitterAuthView, TwitterAuthPresenter>
    implements TwitterAuthView {
  private static final String TAG = TwitterAuthActivity.class.getSimpleName();

  @BindView(R.id.webview)
  WebView webView;

  @Inject TwitterAuthPresenter twitterAuthPresenter;
  @Inject Preferences preferences;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_twitter_auth);
    ButterKnife.bind(this);

    getPresenter().retrieveRequestToken();

    webView.setWebViewClient(
        new WebViewClient() {
          @Override
          public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("oauth")) {
              Uri uri = Uri.parse(url);
              if (uri.getQueryParameter("oauth_verifier") != null) {
                getPresenter().onOAuthCallback(uri);
              }
              return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
          }
        });
  }

  @Override
  public void injectComponent() {
    ComponentHolder.getCoreComponent().twitterAuthComponent().inject(this);
  }

  @NonNull
  @Override
  public TwitterAuthPresenter createPresenter() {
    return twitterAuthPresenter;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    getPresenter().detachView(false);
  }

  @Override
  public void loadUrl(String authUrl) {
    webView.loadUrl(authUrl);
  }

  @Override
  public void startNextActivity() {
    if (!isFinishing()) {
      //      finish();
      Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);
    }
  }
}
