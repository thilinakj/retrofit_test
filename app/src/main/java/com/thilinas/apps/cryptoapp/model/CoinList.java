package com.thilinas.apps.cryptoapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Thilina on 2/6/2018.
 */

public class CoinList {
    @SerializedName("coinList")
    private ArrayList<Coin> coinList;

    public ArrayList<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(ArrayList<Coin> coins) {
        this.coinList = coins;
    }
}
