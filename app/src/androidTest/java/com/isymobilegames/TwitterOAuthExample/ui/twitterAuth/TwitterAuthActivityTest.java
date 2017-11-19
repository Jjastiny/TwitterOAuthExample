package com.isymobilegames.TwitterOAuthExample.ui.twitterAuth;

import android.content.Context;

import com.isymobilegames.TwitterOAuthExample.base.MockedBaseTest;

import org.junit.Test;

import javax.inject.Inject;

import retrofit2.Retrofit;

/** Created by justinyang on 11/17/17. */
public class TwitterAuthActivityTest extends MockedBaseTest {
  @Inject Retrofit retrofit;

  @Inject Context context;

  @Test
  public void name() throws Exception {
    //    getBaseComponent().inject(this);
  }
}
