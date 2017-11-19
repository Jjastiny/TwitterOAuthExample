package com.isymobilegames.TwitterOAuthExample.ui.twitterAuth;

import com.isymobilegames.TwitterOAuthExample.util.Preferences;

import dagger.Module;
import dagger.Provides;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;

/** Created by justinyang on 11/15/17. */
@Module
public class TwitterAuthModule {

  @Provides
  TwitterAuthPresenter providesTwitterAuthPresenter(
      Preferences preferences, OAuthConsumer consumer, OAuthProvider provider) {
    return new TwitterAuthPresenter(preferences, consumer, provider);
  }
}
