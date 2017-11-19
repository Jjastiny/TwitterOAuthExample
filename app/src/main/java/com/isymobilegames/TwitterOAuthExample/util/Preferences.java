package com.isymobilegames.TwitterOAuthExample.util;

import android.content.Context;
import android.content.SharedPreferences;

/** Created by justinyang on 11/15/17. */
public class Preferences {
  private static final String TOKEN = "token";
  private static final String TOKEN_SECRET = "token_secret";

  private SharedPreferences sharedPreferences;
  private SharedPreferences.Editor prefEditor;

  public Preferences(Context context) {
    sharedPreferences =
        context.getSharedPreferences(context.getApplicationInfo().name, Context.MODE_PRIVATE);
    prefEditor = sharedPreferences.edit();
  }

  public void setApiKey(String apiKey) {
    prefEditor.putString(TOKEN, apiKey);
    prefEditor.apply();
  }

  public void setApiSecret(String apiSecret) {
    prefEditor.putString(TOKEN_SECRET, apiSecret);
    prefEditor.apply();
  }

  public String getToken() {
    return sharedPreferences.getString(TOKEN, "");
  }

  public String getTokenSecret() {
    return sharedPreferences.getString(TOKEN_SECRET, "");
  }
}
