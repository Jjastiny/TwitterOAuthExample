package com.isymobilegames.TwitterOAuthExample.dagger.module;

import com.isymobilegames.TwitterOAuthExample.rest.BaseService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/** Created by justinyang on 11/15/17. */
@Module
public class RestModule {

  @Provides
  @Singleton
  BaseService providesBaseService(Retrofit retrofit) {
    return retrofit.create(BaseService.class);
  }
}
