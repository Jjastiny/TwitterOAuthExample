package com.isymobilegames.TwitterOAuthExample.dagger.modules;

import android.support.test.espresso.core.deps.dagger.Module;
import android.support.test.espresso.core.deps.dagger.Provides;

import javax.inject.Singleton;

import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

/** Created by justinyang on 11/17/17. */
@Module
public class MockedRetrofitModule {

  @Provides
  @Singleton
  Retrofit providesAuthedRetrofit() {
    return mock(Retrofit.class);
  }
}
