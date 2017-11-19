package com.isymobilegames.TwitterOAuthExample.data.status;

import java.util.List;

public class UrlsItem{
	private Object displayUrl;
	private List<Integer> indices;
	private Object expandedUrl;
	private String url;

	public void setDisplayUrl(Object displayUrl){
		this.displayUrl = displayUrl;
	}

	public Object getDisplayUrl(){
		return displayUrl;
	}

	public void setIndices(List<Integer> indices){
		this.indices = indices;
	}

	public List<Integer> getIndices(){
		return indices;
	}

	public void setExpandedUrl(Object expandedUrl){
		this.expandedUrl = expandedUrl;
	}

	public Object getExpandedUrl(){
		return expandedUrl;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"UrlsItem{" + 
			"display_url = '" + displayUrl + '\'' + 
			",indices = '" + indices + '\'' + 
			",expanded_url = '" + expandedUrl + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}