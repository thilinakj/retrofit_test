package com.thilinas.apps.cryptoapp.network.cache;

import com.thilinas.apps.cryptoapp.model.Crypto;
import com.thilinas.apps.cryptoapp.model.Global;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Thilina on 2/9/2018.
 */

public interface IExampleNetwork {
    @GET("ticker/")
    Single<List<Crypto>> getDetails(@Query("limit") int size);

    @GET("ticker/")
    Single<List<Crypto>> getCachedDetails(@Query("limit") int size);

    @GET("global/")
    Single<Response<Global>> getGlobalDetails(@Query("convert") String cur);

    @GET("global/")
    Single<Response<Global>> getCachedGlobalDetails(@Query("convert") String cur);
}
