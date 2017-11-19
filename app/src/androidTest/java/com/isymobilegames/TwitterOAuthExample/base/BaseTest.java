package com.isymobilegames.TwitterOAuthExample.base;

import com.isymobilegames.TwitterOAuthExample.dagger.ComponentHolder;
import com.isymobilegames.TwitterOAuthExample.dagger.CoreComponent;

import org.junit.After;
import org.junit.Before;

/** Created by justinyang on 11/17/17. */
public abstract class BaseTest<C extends CoreComponent> {
  private C baseComponent;

  protected abstract C buildComponent();

  @Before
  public void setUp() throws Exception {
    baseComponent = buildComponent();
    ComponentHolder.setCoreComponent(baseComponent);
  }

  @After
  public void tearDown() throws Exception {
    baseComponent = null;
  }

  protected C getBaseComponent() {
    return baseComponent;
  }
}
