package com.thilinas.apps.cryptoapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import com.thilinas.apps.cryptoapp.R;
import com.thilinas.apps.cryptoapp.model.Crypto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thilina on 2/6/2018.
 */

public class CoinListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Object> coins;
    // A menu item view type.
    private static final int MENU_ITEM_VIEW_TYPE = 0;
    // The native app install ad view type.
    private static final int NATIVE_APP_INSTALL_AD_VIEW_TYPE = 1;
    // The native content ad view type.
    private static final int NATIVE_CONTENT_AD_VIEW_TYPE = 2;

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

    public class NativeAppInstallAdViewHolder extends RecyclerView.ViewHolder {
        NativeAppInstallAdViewHolder(View view) {
            super(view);
            NativeAppInstallAdView adView = (NativeAppInstallAdView) view;

            // Register the view used for each individual asset.
            // The MediaView will display a video asset if one is present in the ad, and the
            // first image asset otherwise.
            MediaView mediaView = (MediaView) adView.findViewById(R.id.appinstall_media);
            adView.setMediaView(mediaView);
            adView.setHeadlineView(adView.findViewById(R.id.appinstall_headline));
            adView.setBodyView(adView.findViewById(R.id.appinstall_body));
            adView.setCallToActionView(adView.findViewById(R.id.appinstall_call_to_action));
            adView.setIconView(adView.findViewById(R.id.appinstall_app_icon));
            adView.setPriceView(adView.findViewById(R.id.appinstall_price));
            adView.setStarRatingView(adView.findViewById(R.id.appinstall_stars));
            adView.setStoreView(adView.findViewById(R.id.appinstall_store));
        }
    }

    public class NativeContentAdViewHolder extends RecyclerView.ViewHolder {
        NativeContentAdViewHolder(View view) {
            super(view);
            NativeContentAdView adView = (NativeContentAdView) view;

            // Register the view used for each individual asset.
            adView.setHeadlineView(adView.findViewById(R.id.contentad_headline));
            adView.setImageView(adView.findViewById(R.id.contentad_image));
            adView.setBodyView(adView.findViewById(R.id.contentad_body));
            adView.setCallToActionView(adView.findViewById(R.id.contentad_call_to_action));
            adView.setLogoView(adView.findViewById(R.id.contentad_logo));
            adView.setAdvertiserView(adView.findViewById(R.id.contentad_advertiser));
        }
    }


    public CoinListAdapter(ArrayList<Object> coinList) {
        this.coins = coinList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case NATIVE_APP_INSTALL_AD_VIEW_TYPE:
                View nativeAppInstallLayoutView = LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.ad_app_install,
                        parent, false);
                return new NativeAppInstallAdViewHolder(nativeAppInstallLayoutView);
            case NATIVE_CONTENT_AD_VIEW_TYPE:
                View nativeContentLayoutView = LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.ad_content,
                        parent, false);
                return new NativeContentAdViewHolder(nativeContentLayoutView);
            case MENU_ITEM_VIEW_TYPE:
                // Fall through.
            default:
                View itemView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.layout_coin_list_row, parent, false);
                return new MyViewHolder(itemView);
        }
        /*View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_coin_list_row, parent, false);
        return new MyViewHolder(itemView);*/
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case NATIVE_APP_INSTALL_AD_VIEW_TYPE:
                NativeAppInstallAd appInstallAd = (NativeAppInstallAd) coins.get(position);
                populateAppInstallAdView(appInstallAd, (NativeAppInstallAdView) holder.itemView);
                break;
            case NATIVE_CONTENT_AD_VIEW_TYPE:
                NativeContentAd contentAd = (NativeContentAd) coins.get(position);
                populateContentAdView(contentAd, (NativeContentAdView) holder.itemView);
                break;
            case MENU_ITEM_VIEW_TYPE:
                // fall through
            default:
                MyViewHolder myViewHolder = (MyViewHolder) holder;
                Crypto crypto = (Crypto) coins.get(position);
                myViewHolder.symbol.setText(crypto.getSymbol());
                myViewHolder.price.setText(crypto.getPriceUsd());
                myViewHolder.cap.setText(crypto.getMarketCapUsd());
                myViewHolder.supply.setText(crypto.getTotalSupply());
        }
    }

   /* @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Crypto crypto = coins.get(position);
        holder.symbol.setText(crypto.getSymbol());
        holder.price.setText(crypto.getPriceUsd());
        holder.cap.setText(crypto.getMarketCapUsd());
        holder.supply.setText(crypto.getTotalSupply());

       *//* TransactionListItem item = coins.get(position);
        holder.tvDate1.setText(Utils.convertDate(item.getDate()));
        holder.tvDate2.setText(Utils.convertDate2(item.getDate()));
        holder.tvShop.setText(item.getMerchant());
        holder.tvBill.setText("Bill number: "+item.getBillNumber());
        holder.tvAmount.setText(String.format("%.2f",item.getAmount())+ " point(s) "+item.getDisplayTransactionType().toLowerCase());*//*
    }*/

    @Override
    public int getItemCount() {
        return (coins == null) ? 0 : coins.size();
        //  return coins.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object recyclerViewItem = coins.get(position);
        if (recyclerViewItem instanceof NativeAppInstallAd) {
            return NATIVE_APP_INSTALL_AD_VIEW_TYPE;
        } else if (recyclerViewItem instanceof NativeContentAd) {
            return NATIVE_CONTENT_AD_VIEW_TYPE;
        }
        return MENU_ITEM_VIEW_TYPE;
    }

    private void populateAppInstallAdView(NativeAppInstallAd nativeAppInstallAd,
                                          NativeAppInstallAdView adView) {

        // Some assets are guaranteed to be in every NativeAppInstallAd.
        ((ImageView) adView.getIconView()).setImageDrawable(nativeAppInstallAd.getIcon()
                .getDrawable());
        ((TextView) adView.getHeadlineView()).setText(nativeAppInstallAd.getHeadline());
        ((TextView) adView.getBodyView()).setText(nativeAppInstallAd.getBody());
        ((Button) adView.getCallToActionView()).setText(nativeAppInstallAd.getCallToAction());

        // These assets aren't guaranteed to be in every NativeAppInstallAd, so it's important to
        // check before trying to display them.
        if (nativeAppInstallAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAppInstallAd.getPrice());
        }

        if (nativeAppInstallAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAppInstallAd.getStore());
        }

        if (nativeAppInstallAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAppInstallAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        // Assign native ad object to the native view.
        adView.setNativeAd(nativeAppInstallAd);
    }

    private void populateContentAdView(NativeContentAd nativeContentAd,
                                       NativeContentAdView adView) {
        // Some assets are guaranteed to be in every NativeContentAd.
        ((TextView) adView.getHeadlineView()).setText(nativeContentAd.getHeadline());
        ((TextView) adView.getBodyView()).setText(nativeContentAd.getBody());
        ((TextView) adView.getCallToActionView()).setText(nativeContentAd.getCallToAction());
        ((TextView) adView.getAdvertiserView()).setText(nativeContentAd.getAdvertiser());

        List<NativeAd.Image> images = nativeContentAd.getImages();

        if (images.size() > 0) {
            ((ImageView) adView.getImageView()).setImageDrawable(images.get(0).getDrawable());
        }

        // Some aren't guaranteed, however, and should be checked.
        NativeAd.Image logoImage = nativeContentAd.getLogo();

        if (logoImage == null) {
            adView.getLogoView().setVisibility(View.INVISIBLE);
        } else {
            ((ImageView) adView.getLogoView()).setImageDrawable(logoImage.getDrawable());
            adView.getLogoView().setVisibility(View.VISIBLE);
        }

        // Assign native ad object to the native view.
        adView.setNativeAd(nativeContentAd);
    }

}
