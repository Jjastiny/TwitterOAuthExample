package com.isymobilegames.TwitterOAuthExample.dagger.module;

import android.content.Context;

import com.isymobilegames.TwitterOAuthExample.util.Preferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/** Created by justinyang on 10/29/17. */
@Module
public class AndroidModule {
  Context context;

  public AndroidModule(Context context) {
    this.context = context;
  }

  @Provides
  @Singleton
  Context applicationContext() {
    return context;
  }

  @Provides
  @Singleton
  Preferences providesPreferences(Context context) {
    return new Preferences(context);
  }
}
