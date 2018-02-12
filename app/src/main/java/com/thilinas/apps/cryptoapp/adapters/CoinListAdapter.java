package com.thilinas.apps.cryptoapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thilinas.apps.cryptoapp.R;
import com.thilinas.apps.cryptoapp.model.Coin;
import com.thilinas.apps.cryptoapp.model.Crypto;

import java.util.ArrayList;

/**
 * Created by Thilina on 2/6/2018.
 */

public class CoinListAdapter extends RecyclerView.Adapter<CoinListAdapter.MyViewHolder> {

    private ArrayList<Crypto> coins;

    public class MyViewHolder extends RecyclerView.ViewHolder {

       // CustomTextView tvDate1,tvDate2,tvShop,tvBill,tvAmount;
        TextView symbol,price,cap,supply;

        public MyViewHolder(View view) {
            super(view);
            symbol = (TextView) view.findViewById(R.id.tv_sym);
            price = (TextView) view.findViewById(R.id.tv_price);
            cap = (TextView) view.findViewById(R.id.tv_cap);
            supply = (TextView) view.findViewById(R.id.tv_supply);
          /*  tvDate1= (CustomTextView) view.findViewById(R.id.tvDate1);
            tvDate2= (CustomTextView) view.findViewById(R.id.tvDate2);
            tvShop= (CustomTextView) view.findViewById(R.id.tvShop);
            tvBill= (CustomTextView) view.findViewById(R.id.tvBill);
            tvAmount= (CustomTextView) view.findViewById(R.id.tvAmount);*/
        }
    }


    public CoinListAdapter(ArrayList<Crypto> coinList) {
        this.coins = coinList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_coin_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Crypto crypto = coins.get(position);
        holder.symbol.setText(crypto.getSymbol());
        holder.price.setText(crypto.getPriceUsd());
        holder.cap.setText(crypto.getMarketCapUsd());
        holder.supply.setText(crypto.getTotalSupply());

       /* TransactionListItem item = coins.get(position);
        holder.tvDate1.setText(Utils.convertDate(item.getDate()));
        holder.tvDate2.setText(Utils.convertDate2(item.getDate()));
        holder.tvShop.setText(item.getMerchant());
        holder.tvBill.setText("Bill number: "+item.getBillNumber());
        holder.tvAmount.setText(String.format("%.2f",item.getAmount())+ " point(s) "+item.getDisplayTransactionType().toLowerCase());*/
    }

    @Override
    public int getItemCount() {
        return coins.size();
    }

}
