package com.isymobilegames.TwitterOAuthExample.ui.twitterAuth;

import android.net.Uri;

import com.isymobilegames.TwitterOAuthExample.util.Preferences;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/** Created by justinyang on 11/17/17. */
public class TwitterAuthPresenterTest {

  public static final String RANDOM_STRING = "justin_awesome";
  public static final String TOKEN_STRING = "justin_token";
  public static final String TOKEN_SECRET_STRING = "justin_token_secret";

  @Mock private OAuthProvider provider;
  @Mock private OAuthConsumer consumer;
  @Mock private Preferences preferences;
  @Mock private TwitterAuthView twitterAuthView;
  @InjectMocks private TwitterAuthPresenter twitterAuthPresenter;

  private TestScheduler testScheduler = new TestScheduler();

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    RxJavaPlugins.setIoSchedulerHandler(scheduler -> testScheduler);
    RxAndroidPlugins.setInitMainThreadSchedulerHandler(
        schedulerCallable -> Schedulers.trampoline());

    twitterAuthPresenter.attachView(twitterAuthView);
  }

  @After
  public void tearDown() throws Exception {
    RxJavaPlugins.reset();
    RxAndroidPlugins.reset();
  }

  @Test
  public void retrieveRequestToken()
      throws OAuthCommunicationException, OAuthExpectationFailedException,
          OAuthNotAuthorizedException, OAuthMessageSignerException {

    when(provider.retrieveRequestToken(any(OAuthConsumer.class), anyString()))
        .thenReturn(RANDOM_STRING);

    twitterAuthPresenter.retrieveRequestToken();
    testScheduler.advanceTimeBy(1000, TimeUnit.MILLISECONDS);

    verify(provider).retrieveRequestToken(eq(consumer), anyString());
    verify(twitterAuthView).loadUrl(anyString());
  }

  @Test
  public void onOAuthCallback()
      throws OAuthCommunicationException, OAuthExpectationFailedException,
          OAuthNotAuthorizedException, OAuthMessageSignerException {

    Uri uri = mock(Uri.class);
    when(uri.getQueryParameter(anyString())).thenReturn(RANDOM_STRING);

    when(preferences.getToken()).thenReturn(TOKEN_STRING);
    when(preferences.getTokenSecret()).thenReturn(TOKEN_SECRET_STRING);

    when(consumer.getToken()).thenReturn(TOKEN_STRING);
    when(consumer.getTokenSecret()).thenReturn(TOKEN_SECRET_STRING);

    twitterAuthPresenter.onOAuthCallback(uri);
    testScheduler.advanceTimeBy(1000, TimeUnit.MILLISECONDS);

    verify(consumer).getToken();
    verify(consumer).getTokenSecret();

    verify(preferences).setApiKey(eq(TOKEN_STRING));
    verify(preferences).setApiSecret(eq(TOKEN_SECRET_STRING));

    verify(provider).retrieveAccessToken(eq(consumer), eq(RANDOM_STRING));
    verify(twitterAuthView).startNextActivity();
  }

  @Test
  public void detachViewDisposable() {
    twitterAuthPresenter.detachView(false);
    twitterAuthPresenter.compositeDisposable.isDisposed();
  }
}
