package com.isymobilegames.TwitterOAuthExample.data.status;

import java.util.List;

public class Url{
	private List<UrlsItem> urls;

	public void setUrls(List<UrlsItem> urls){
		this.urls = urls;
	}

	public List<UrlsItem> getUrls(){
		return urls;
	}

	@Override
 	public String toString(){
		return 
			"Url{" + 
			"urls = '" + urls + '\'' + 
			"}";
		}
}