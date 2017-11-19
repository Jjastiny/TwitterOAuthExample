package com.isymobilegames.TwitterOAuthExample.dagger;

/** Created by justinyang on 10/9/17. */
public class ComponentHolder {
  private ComponentHolder() {}

  private static final ComponentHolder INSTANCE = new ComponentHolder();

  private CoreComponent coreComponent;

  public static ComponentHolder getInstance() {
    return INSTANCE;
  }

  public static CoreComponent getCoreComponent() {
    return getInstance().coreComponent;
  }

  public static void setCoreComponent(CoreComponent coreComponent) {
    getInstance().coreComponent = coreComponent;
  }
}
