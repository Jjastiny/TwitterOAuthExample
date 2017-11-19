package com.isymobilegames.TwitterOAuthExample.ui.twitterAuth;

import android.net.Uri;
import android.support.annotation.VisibleForTesting;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.isymobilegames.TwitterOAuthExample.util.Preferences;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;

/** Created by justinyang on 11/15/17. */
public class TwitterAuthPresenter extends MvpBasePresenter<TwitterAuthView> {

  private static final String TAG = TwitterAuthPresenter.class.getSimpleName();
  private static final String CALLBACK = "oauth://twitter";

  private final OAuthProvider provider;
  private final OAuthConsumer consumer;
  private final Preferences preferences;

  @VisibleForTesting() CompositeDisposable compositeDisposable = new CompositeDisposable();

  public TwitterAuthPresenter(
      Preferences preferences, OAuthConsumer consumer, OAuthProvider provider) {
    this.preferences = preferences;
    this.consumer = consumer;
    this.provider = provider;
  }

  @Override
  public void attachView(TwitterAuthView view) {
    super.attachView(view);
  }

  public void retrieveRequestToken() {
    compositeDisposable.add(
        Flowable.fromCallable(() -> provider.retrieveRequestToken(consumer, CALLBACK))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter(authUrl -> !authUrl.isEmpty())
            .subscribe(
                authUrl -> getView().loadUrl(authUrl), throwable -> throwable.printStackTrace()));
  }

  @Override
  public void detachView(boolean retainInstance) {
    super.detachView(retainInstance);
    compositeDisposable.clear();
  }

  public void onOAuthCallback(Uri uri) {
    compositeDisposable.add(
        Flowable.fromCallable(
                () -> {
                  String pinCode = uri.getQueryParameter("oauth_verifier");
                  provider.retrieveAccessToken(consumer, pinCode);
                  return consumer;
                })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext(oAuthConsumer -> saveTokens())
            .subscribe(
                oAuthConsumer -> {
                  if (!preferences.getToken().isEmpty()
                      && !preferences.getTokenSecret().isEmpty()) {
                    getView().startNextActivity();
                  }
                },
                throwable -> throwable.printStackTrace()));
  }

  private void saveTokens() {
    String token = consumer.getToken();
    String tokenSecret = consumer.getTokenSecret();

    preferences.setApiKey(token);
    preferences.setApiSecret(tokenSecret);
  }
}
