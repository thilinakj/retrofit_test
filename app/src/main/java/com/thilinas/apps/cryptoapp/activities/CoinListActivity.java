package com.thilinas.apps.cryptoapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.thilinas.apps.cryptoapp.R;
import com.thilinas.apps.cryptoapp.adapters.CoinListAdapter;
import com.thilinas.apps.cryptoapp.model.Crypto;
import com.thilinas.apps.cryptoapp.model.Global;
import com.thilinas.apps.cryptoapp.network.GetCoinsDataService;
import com.thilinas.apps.cryptoapp.network.RetrofitInstance;
import com.thilinas.apps.cryptoapp.network.cache.ExampleNetwork;
import com.thilinas.apps.cryptoapp.network.cache.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinListActivity extends AppCompatActivity {

    private ArrayList<Crypto> coins;
    private RecyclerView recyclerView;
    private CoinListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_list);
        initViews();
        prepareList();
      //  updateList();  // normal api call
        getDetails(50); // cachebale api call
        getGlobalData();
    }

    private void initViews(){
        recyclerView = (RecyclerView) findViewById(R.id.rv);
    }

    private void prepareList() {
        coins = new ArrayList<>();
        mAdapter = new CoinListAdapter(coins);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

       /* for(int i = 0; i<5; i++){
            coins.add(new Coin());
        }*/
        mAdapter.notifyDataSetChanged();
    }

    private ExampleNetwork mExampleNetwork;

    private void getCacheData(){
        Log.d("DODOFO","getCacheData");
        Single<List<Crypto>> london = mExampleNetwork.getCachedDetails(50);
        london
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    Log.d("DODOFO","cache finally");
                })
                .subscribe(details -> updateData(details), this::onErrorX);
    }

    private void onErrorX(Throwable throwable) {
        Log.d("DODOFO","cache failed "+throwable.getMessage());
    }

    RetrofitManager retrofitManager;
    private void getDetails(int size) {
        retrofitManager = new RetrofitManager(CoinListActivity.this);
        mExampleNetwork = new ExampleNetwork(retrofitManager) ;

        Single<List<Crypto>> london = mExampleNetwork.getDetails(50);
        london
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    Log.d("DODOFO","new data finally");
                   /* mExampleNetwork
                            .getDetails(size) // From Network
                            .subscribe(details -> updateData(details), this::onError);*/
                })
                .subscribe(details -> updateData(details), this::onError);


       /* Single<List<Crypto>> call = mExampleNetwork.getDetails(size);
        call
                .enqueue(new Callback<List<Crypto>>() {
            @Override
            public void onResponse(Call<List<Crypto>> call, Response<List<Crypto>> response) {
                List<Crypto> crl = response.body();
                if(response.isSuccessful() && crl != null){
                    Log.d("DODOFO","scc ");
                    coins.clear();

                    coins.addAll((ArrayList) crl);
                    mAdapter.notifyDataSetChanged();
                }else {
                    Log.d("DODOFO","uns ");
                }
            }

            @Override
            public void onFailure(Single<List<Crypto>> call, Throwable t) {
               // updateData(mExampleNetwork.getCachedDetails(size).);
            }
        });*/

       /* mExampleNetwork.getCachedDetails(size)
                .// From Cache
                .doFinally(() -> {
                    mExampleNetwork
                            .getDetails(size) // From Network
                            .subscribe(details -> onDetailsReceived(details), this::onError);
                })
                .subscribe(details -> updateData(details), this::onError);*/
    }

    private void getGlobalData(){
        if(retrofitManager == null){
            retrofitManager = new RetrofitManager(CoinListActivity.this);
            mExampleNetwork = new ExampleNetwork(retrofitManager) ;
        }
        mExampleNetwork.getGlobalDetails("GBP")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(details -> updateGlobalData(details), this::onErrorGlobal);
    }

    private void getCacheGlobalData(){
        if(retrofitManager == null){
            retrofitManager = new RetrofitManager(CoinListActivity.this);
            mExampleNetwork = new ExampleNetwork(retrofitManager) ;
        }
        mExampleNetwork.getCachedGlobalDetails("GBP")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(details -> updateGlobalData(details), this::onErrorGlobalCache);
    }

    private void updateGlobalData(Response<Global> details) {
        Toast.makeText(getApplicationContext(),details.toString() + " "+details.code(),Toast.LENGTH_LONG).show();
    }

    private void onErrorGlobal(Throwable throwable) {
        Log.d("DODOFO","onErrorGlobal global"+ throwable.getMessage());
        getCacheGlobalData();
    }

    private void onErrorGlobalCache(Throwable throwable) {
        Log.d("DODOFO","onErrorGlobalCache failed "+throwable.getMessage());
    }


    private void onError(Throwable throwable) {
        Log.d("DODOFO","onError "+ throwable.getMessage());
        getCacheData();
    }


    private void updateList(){
        /*Create handle for the RetrofitInstance interface*/
        GetCoinsDataService service = RetrofitInstance.getRetrofitInstance().create(GetCoinsDataService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<List<Crypto>> call = service.getCoinsData(50);

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");
        Log.d("DODOFO","URL Called "+ call.request().url());
        call.enqueue(new Callback<List<Crypto>>() {
            @Override
            public void onResponse(Call<List<Crypto>> call, Response<List<Crypto>> response) {
                List<Crypto> crl = response.body();
                if(response.isSuccessful() && crl != null){
                    Log.d("DODOFO","scc ");
                    coins.clear();

                    coins.addAll((ArrayList) crl);
                    mAdapter.notifyDataSetChanged();
                }else {
                    Log.d("DODOFO","uns ");
                }
            }

            @Override
            public void onFailure(Call<List<Crypto>> call, Throwable t) {
                Log.d("DODOFO","fail "+t.getMessage()+" \n"+t.getLocalizedMessage());
                Toast.makeText(CoinListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        /*call.enqueue(new Callback<List<Crypto>>() {
            @Override
            public void onResponse(Call<List<Crypto>> call, Response<List<Crypto>> response) {
             //   generateEmployeeList(response.body().getEmployeeArrayList());
               *//* if(response.isSuccessful() && response.body().getCoinList() != null){
                    Log.d("DODOFO","scc ");
                    coins.clear();

                    coins.addAll(response.body().getCoinList());
                    mAdapter.notifyDataSetChanged();
                }else {
                    Log.d("DODOFO","uns ");
                }*//*
            }

            @Override
            public void onFailure(Call<CoinList> call, Throwable t) {
                Log.d("DODOFO","fail "+t.getMessage()+" \n"+t.getLocalizedMessage());
                Toast.makeText(CoinListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    private void updateData(List<Crypto> list){
        coins.clear();

        coins.addAll((ArrayList) list);
        mAdapter.notifyDataSetChanged();
    }
}
