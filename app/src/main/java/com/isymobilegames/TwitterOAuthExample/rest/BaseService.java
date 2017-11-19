package com.isymobilegames.TwitterOAuthExample.rest;

import com.isymobilegames.TwitterOAuthExample.data.status.Response;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/** Created by justinyang on 11/15/17. */
public interface BaseService {
  @GET("statuses/home_timeline.json")
  Flowable<List<Response>> getStatus();
}
