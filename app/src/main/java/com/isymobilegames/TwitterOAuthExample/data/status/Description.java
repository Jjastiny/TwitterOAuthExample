package com.isymobilegames.TwitterOAuthExample.data.status;

import java.util.List;

public class Description{
	private List<Object> urls;

	public void setUrls(List<Object> urls){
		this.urls = urls;
	}

	public List<Object> getUrls(){
		return urls;
	}

	@Override
 	public String toString(){
		return 
			"Description{" + 
			"urls = '" + urls + '\'' + 
			"}";
		}
}