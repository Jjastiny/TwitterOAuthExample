package com.isymobilegames.TwitterOAuthExample.ui.twitterAuth;

import dagger.Subcomponent;

/** Created by justinyang on 11/15/17. */
@TwitterAuthScope
@Subcomponent(modules = {TwitterAuthModule.class})
public interface TwitterAuthComponent {
  void inject(TwitterAuthActivity twitterAuthActivity);

}
