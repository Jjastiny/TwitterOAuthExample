package com.isymobilegames.TwitterOAuthExample.dagger.modules;

import android.support.test.espresso.core.deps.dagger.Component;

import com.isymobilegames.TwitterOAuthExample.dagger.CoreComponent;
import com.isymobilegames.TwitterOAuthExample.ui.twitterAuth.TwitterAuthActivityTest;
import com.isymobilegames.TwitterOAuthExample.ui.twitterAuth.TwitterAuthModule;

import javax.inject.Singleton;

/** Created by justinyang on 11/17/17. */
@Singleton
@Component(
  modules = {MockedRetrofitModule.class, MockedAndroidModule.class, TwitterAuthModule.class}
)
public interface MockedCoreComponent extends CoreComponent {
  void inject(TwitterAuthActivityTest twitterAuthActivityTest);
}
