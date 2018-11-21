package com.wjk32.docclassifier.modules.home;

import android.util.Log;

import com.wjk32.docclassifier.Constants;
import com.wjk32.docclassifier.entity.Label;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jikang Wang on 11/16/18.
 */
public class HomePresenter implements HomeContract.Presenter {

    private final HomeContract.View mHomeView;

    public HomePresenter(HomeContract.View mProblemsView) {
        this.mHomeView = mProblemsView;
        mProblemsView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public String getLabel(String s) {
        okhttp3.OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        PredictInterface apiService = retrofit.create(PredictInterface.class);

        Call<Label> c = apiService.getNewsCall(s);
        Log.e("URL", s + "  " + c.request().url().toString());
        Observable<Label> observable = apiService.getNews(s);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Label>() {
                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e);
                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Label label) {
                        mHomeView.showLabel(label.getLabel());
                    }
                });
        return null;
    }
}
