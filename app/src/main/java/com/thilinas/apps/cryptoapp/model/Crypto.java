package com.thilinas.apps.cryptoapp.model;

import com.google.gson.annotations.SerializedName;

public class Crypto{

	@SerializedName("price_usd")
	private String priceUsd;

	@SerializedName("symbol")
	private String symbol;

	@SerializedName("last_updated")
	private String lastUpdated;

	@SerializedName("total_supply")
	private String totalSupply;

	@SerializedName("24h_volume_usd")
	private String jsonMember24hVolumeUsd;

	@SerializedName("price_btc")
	private String priceBtc;

	@SerializedName("available_supply")
	private String availableSupply;

	@SerializedName("market_cap_usd")
	private String marketCapUsd;

	@SerializedName("percent_change_1h")
	private String percentChange1h;

	@SerializedName("percent_change_24h")
	private String percentChange24h;

	@SerializedName("name")
	private String name;

	@SerializedName("max_supply")
	private String maxSupply;

	@SerializedName("rank")
	private String rank;

	@SerializedName("id")
	private String id;

	@SerializedName("percent_change_7d")
	private String percentChange7d;

	public void setPriceUsd(String priceUsd){
		this.priceUsd = priceUsd;
	}

	public String getPriceUsd(){
		return priceUsd;
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setTotalSupply(String totalSupply){
		this.totalSupply = totalSupply;
	}

	public String getTotalSupply(){
		return totalSupply;
	}

	public void setJsonMember24hVolumeUsd(String jsonMember24hVolumeUsd){
		this.jsonMember24hVolumeUsd = jsonMember24hVolumeUsd;
	}

	public String getJsonMember24hVolumeUsd(){
		return jsonMember24hVolumeUsd;
	}

	public void setPriceBtc(String priceBtc){
		this.priceBtc = priceBtc;
	}

	public String getPriceBtc(){
		return priceBtc;
	}

	public void setAvailableSupply(String availableSupply){
		this.availableSupply = availableSupply;
	}

	public String getAvailableSupply(){
		return availableSupply;
	}

	public void setMarketCapUsd(String marketCapUsd){
		this.marketCapUsd = marketCapUsd;
	}

	public String getMarketCapUsd(){
		return marketCapUsd;
	}

	public void setPercentChange1h(String percentChange1h){
		this.percentChange1h = percentChange1h;
	}

	public String getPercentChange1h(){
		return percentChange1h;
	}

	public void setPercentChange24h(String percentChange24h){
		this.percentChange24h = percentChange24h;
	}

	public String getPercentChange24h(){
		return percentChange24h;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setMaxSupply(String maxSupply){
		this.maxSupply = maxSupply;
	}

	public String getMaxSupply(){
		return maxSupply;
	}

	public void setRank(String rank){
		this.rank = rank;
	}

	public String getRank(){
		return rank;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPercentChange7d(String percentChange7d){
		this.percentChange7d = percentChange7d;
	}

	public String getPercentChange7d(){
		return percentChange7d;
	}

	@Override
 	public String toString(){
		return 
			"Crypto{" + 
			"price_usd = '" + priceUsd + '\'' + 
			",symbol = '" + symbol + '\'' + 
			",last_updated = '" + lastUpdated + '\'' + 
			",total_supply = '" + totalSupply + '\'' + 
			",24h_volume_usd = '" + jsonMember24hVolumeUsd + '\'' + 
			",price_btc = '" + priceBtc + '\'' + 
			",available_supply = '" + availableSupply + '\'' + 
			",market_cap_usd = '" + marketCapUsd + '\'' + 
			",percent_change_1h = '" + percentChange1h + '\'' + 
			",percent_change_24h = '" + percentChange24h + '\'' + 
			",name = '" + name + '\'' + 
			",max_supply = '" + maxSupply + '\'' + 
			",rank = '" + rank + '\'' + 
			",id = '" + id + '\'' + 
			",percent_change_7d = '" + percentChange7d + '\'' + 
			"}";
		}
}