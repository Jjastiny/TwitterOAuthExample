package com.isymobilegames.TwitterOAuthExample.rest;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.http.HttpRequest;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/** Created by justinyang on 11/16/17. */
public class SignedOkClient extends OkHttpClient {
  private static final String TAG = "SignedOkClient";

  private OAuthConsumer mConsumer = null;

  public SignedOkClient(OAuthConsumer consumer) {
    super();
    mConsumer = consumer;
  }

  @Override
  public Call newCall(Request request) {
    Call connection = super.newCall(request);
    //    HttpRequest signedReq = mConsumer.sign(connection);
    try {
      HttpRequest signedReq = mConsumer.sign(connection.request());
    } catch (OAuthMessageSignerException e) {
      e.printStackTrace();
    } catch (OAuthExpectationFailedException e) {
      e.printStackTrace();
    } catch (OAuthCommunicationException e) {
      e.printStackTrace();
    }
    return connection;
  }
  //
  //    @Override
  //    protected HttpURLConnection openConnection(Request request)
  //            throws IOException {
  //        HttpURLConnection connection = super.openConnection(request);
  //        try {
  //            HttpRequest signedReq = mConsumer.sign(connection);
  //        } catch (OAuthMessageSignerException e) {
  //            e.printStackTrace();
  //        } catch (OAuthExpectationFailedException e) {
  //            e.printStackTrace();
  //        } catch (OAuthCommunicationException e) {
  //            e.printStackTrace();
  //        }
  //        return connection;
  //    }
}
