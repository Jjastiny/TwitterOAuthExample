package com.isymobilegames.TwitterOAuthExample.ui.twitterAuth;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/** Created by justinyang on 11/15/17. */
public interface TwitterAuthView extends MvpView {
  void loadUrl(String authUrl);

  void startNextActivity();
}
