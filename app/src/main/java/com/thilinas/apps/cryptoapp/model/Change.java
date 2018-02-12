package com.thilinas.apps.cryptoapp.model;

import com.google.gson.annotations.SerializedName;


public class Change{

	@SerializedName("hour")
	private String hour;

	@SerializedName("day")
	private String day;

	public void setHour(String hour){
		this.hour = hour;
	}

	public String getHour(){
		return hour;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	@Override
 	public String toString(){
		return 
			"Change{" + 
			"hour = '" + hour + '\'' + 
			",day = '" + day + '\'' + 
			"}";
		}
}