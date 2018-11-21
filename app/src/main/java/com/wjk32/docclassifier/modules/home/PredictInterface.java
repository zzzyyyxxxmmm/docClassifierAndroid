package com.wjk32.docclassifier.modules.home;

import com.wjk32.docclassifier.entity.Label;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jikang Wang on 11/16/18.
 */
public interface PredictInterface {
    @GET("api/v1.0/predict")
    Observable<Label> getNews(@Query("words") String words);

    @GET("api/v1.0/predict")
    Call<Label> getNewsCall(@Query("words") String words);
}
