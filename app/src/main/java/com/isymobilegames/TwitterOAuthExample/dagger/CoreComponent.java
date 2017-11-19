package com.isymobilegames.TwitterOAuthExample.dagger;

import com.isymobilegames.TwitterOAuthExample.dagger.module.AndroidModule;
import com.isymobilegames.TwitterOAuthExample.dagger.module.AuthenticatedRetrofitModule;
import com.isymobilegames.TwitterOAuthExample.dagger.module.RestModule;
import com.isymobilegames.TwitterOAuthExample.ui.twitterAuth.TwitterAuthComponent;

import javax.inject.Singleton;

import dagger.Component;

/** Created by justinyang on 10/9/17. */
@Singleton
@Component(modules = {AndroidModule.class, RestModule.class, AuthenticatedRetrofitModule.class})
public interface CoreComponent extends CoreComponentBase {
  TwitterAuthComponent twitterAuthComponent();
}
