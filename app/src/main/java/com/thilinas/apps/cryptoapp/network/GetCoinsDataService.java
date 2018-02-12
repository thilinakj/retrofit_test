package com.thilinas.apps.cryptoapp.network;

import com.thilinas.apps.cryptoapp.model.CoinList;
import com.thilinas.apps.cryptoapp.model.Crypto;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Thilina on 2/6/2018.
 */

public interface GetCoinsDataService {
    /*@GET("ticker/{size}")
    Call<CoinList> getCoinsData(@Path("size") int size);*/
    @GET("ticker/")
    Call<List<Crypto>> getCoinsData(@Query("limit") int size);

    @GET("ticker/")
    Call<ResponseBody> getCoinsDatac(@Query("limit") int size);
}