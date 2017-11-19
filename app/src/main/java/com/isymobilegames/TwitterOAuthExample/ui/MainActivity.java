package com.isymobilegames.TwitterOAuthExample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.isymobilegames.TwitterOAuthExample.R;
import com.isymobilegames.TwitterOAuthExample.dagger.ComponentHolder;
import com.isymobilegames.TwitterOAuthExample.rest.BaseService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  @BindView(R.id.text_view)
  TextView textView;

  @Inject BaseService baseService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ComponentHolder.getCoreComponent().inject(this);
    ButterKnife.bind(this);

    baseService
        .getStatus()
        .flatMapIterable(responses -> responses)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            status -> textView.setText(status.getText()), throwable -> throwable.printStackTrace());
  }
}
