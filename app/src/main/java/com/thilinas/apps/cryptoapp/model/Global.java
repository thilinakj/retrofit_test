package com.thilinas.apps.cryptoapp.model;

import com.google.gson.annotations.SerializedName;

public class Global{

	@SerializedName("bitcoin_percentage_of_market_cap")
	private double bitcoinPercentageOfMarketCap;

	@SerializedName("last_updated")
	private int lastUpdated;

	@SerializedName("total_24h_volume_usd")
	private long total24hVolumeUsd;

	@SerializedName("active_assets")
	private int activeAssets;

	@SerializedName("total_market_cap_usd")
	private long totalMarketCapUsd;

	@SerializedName("active_currencies")
	private int activeCurrencies;

	@SerializedName("active_markets")
	private int activeMarkets;

	public void setBitcoinPercentageOfMarketCap(double bitcoinPercentageOfMarketCap){
		this.bitcoinPercentageOfMarketCap = bitcoinPercentageOfMarketCap;
	}

	public double getBitcoinPercentageOfMarketCap(){
		return bitcoinPercentageOfMarketCap;
	}

	public void setLastUpdated(int lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public int getLastUpdated(){
		return lastUpdated;
	}

	public void setTotal24hVolumeUsd(long total24hVolumeUsd){
		this.total24hVolumeUsd = total24hVolumeUsd;
	}

	public long getTotal24hVolumeUsd(){
		return total24hVolumeUsd;
	}

	public void setActiveAssets(int activeAssets){
		this.activeAssets = activeAssets;
	}

	public int getActiveAssets(){
		return activeAssets;
	}

	public void setTotalMarketCapUsd(long totalMarketCapUsd){
		this.totalMarketCapUsd = totalMarketCapUsd;
	}

	public long getTotalMarketCapUsd(){
		return totalMarketCapUsd;
	}

	public void setActiveCurrencies(int activeCurrencies){
		this.activeCurrencies = activeCurrencies;
	}

	public int getActiveCurrencies(){
		return activeCurrencies;
	}

	public void setActiveMarkets(int activeMarkets){
		this.activeMarkets = activeMarkets;
	}

	public int getActiveMarkets(){
		return activeMarkets;
	}

	@Override
 	public String toString(){
		return 
			"Global{" + 
			"bitcoin_percentage_of_market_cap = '" + bitcoinPercentageOfMarketCap + '\'' + 
			",last_updated = '" + lastUpdated + '\'' + 
			",total_24h_volume_usd = '" + total24hVolumeUsd + '\'' + 
			",active_assets = '" + activeAssets + '\'' + 
			",total_market_cap_usd = '" + totalMarketCapUsd + '\'' + 
			",active_currencies = '" + activeCurrencies + '\'' + 
			",active_markets = '" + activeMarkets + '\'' + 
			"}";
		}
}