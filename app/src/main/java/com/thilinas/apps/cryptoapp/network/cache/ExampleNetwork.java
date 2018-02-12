package com.thilinas.apps.cryptoapp.network.cache;

import android.telecom.Call;

import com.thilinas.apps.cryptoapp.model.Crypto;

import java.util.List;

import com.thilinas.apps.cryptoapp.model.CoinList;
import com.thilinas.apps.cryptoapp.model.Crypto;
import com.thilinas.apps.cryptoapp.model.Global;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
/**
 * Created by Thilina on 2/9/2018.
 */

public class ExampleNetwork implements IExampleNetwork {

    private IExampleNetwork mIExampleNetwork, mICachedExampleNetwork;

    public ExampleNetwork(RetrofitManager retrofitManager) {
        mIExampleNetwork = retrofitManager.getRetrofit().create(IExampleNetwork.class);
        mICachedExampleNetwork = retrofitManager.getCachedRetrofit().create(IExampleNetwork.class);
    }

    /*interface IExampleNetwork {
        @GET("ticker/")
        Single<List<Crypto>> getDetails(@Query("limit") int size);
    }*/

    @Override
    public Single<List<Crypto>> getDetails(int size) {
        return mIExampleNetwork.getDetails(size);
    }

    @Override
    public Single<List<Crypto>> getCachedDetails(int size) {
         return mICachedExampleNetwork.getDetails(size);
    }

    @Override
    public Single<Response<Global>> getGlobalDetails(String cur) {
        return mIExampleNetwork.getGlobalDetails(cur);
    }

    @Override
    public Single<Response<Global>> getCachedGlobalDetails(String cur) {
        return mICachedExampleNetwork.getCachedGlobalDetails(cur);
    }

}
