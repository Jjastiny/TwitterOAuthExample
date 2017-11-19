package com.isymobilegames.TwitterOAuthExample;

import android.app.Application;

import com.isymobilegames.TwitterOAuthExample.dagger.ComponentBuilder;
import com.isymobilegames.TwitterOAuthExample.dagger.ComponentHolder;
import com.isymobilegames.TwitterOAuthExample.dagger.CoreComponent;
import com.isymobilegames.TwitterOAuthExample.dagger.DaggerCoreComponent;
import com.isymobilegames.TwitterOAuthExample.dagger.module.AndroidModule;

/**
 * Created by justinyang on 11/15/17.
 */

public class TwitterOAuthExampleApplication extends Application implements ComponentBuilder {

    @Override
    public void onCreate() {
        super.onCreate();
        if (ComponentHolder.getCoreComponent() == null) {
            ComponentHolder.setCoreComponent(buildCoreComponent());
        }
    }

    @Override
    public CoreComponent buildCoreComponent() {
        return DaggerCoreComponent.builder()
                .androidModule(new AndroidModule(getApplicationContext()))
                .build();
    }
}
