package com.isymobilegames.TwitterOAuthExample.dagger.modules;

import android.content.Context;
import android.support.test.espresso.core.deps.dagger.Module;
import android.support.test.espresso.core.deps.dagger.Provides;

import javax.inject.Singleton;

/** Created by justinyang on 11/17/17. */
@Module
public class MockedAndroidModule {
  private Context context;

  public MockedAndroidModule(Context context) {
    this.context = context;
  }

  @Singleton
  @Provides
  Context providesContext() {
    return context;
  }
}
