package com.isymobilegames.TwitterOAuthExample;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/** Created by justinyang on 11/17/17. */
public class BaseTestRunner extends AndroidJUnitRunner {
  @Override
  public Application newApplication(ClassLoader cl, String className, Context context)
      throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return super.newApplication(cl, TestApplication.class.getName(), context);
  }
}
