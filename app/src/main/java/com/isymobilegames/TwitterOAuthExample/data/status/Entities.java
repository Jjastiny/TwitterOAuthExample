package com.isymobilegames.TwitterOAuthExample.data.status;

import java.util.List;

public class Entities{
	private List<Object> urls;
	private List<Object> hashtags;
	private List<Object> userMentions;
	private List<Object> symbols;

	public void setUrls(List<Object> urls){
		this.urls = urls;
	}

	public List<Object> getUrls(){
		return urls;
	}

	public void setHashtags(List<Object> hashtags){
		this.hashtags = hashtags;
	}

	public List<Object> getHashtags(){
		return hashtags;
	}

	public void setUserMentions(List<Object> userMentions){
		this.userMentions = userMentions;
	}

	public List<Object> getUserMentions(){
		return userMentions;
	}

	public void setSymbols(List<Object> symbols){
		this.symbols = symbols;
	}

	public List<Object> getSymbols(){
		return symbols;
	}

	@Override
 	public String toString(){
		return 
			"Entities{" + 
			"urls = '" + urls + '\'' + 
			",hashtags = '" + hashtags + '\'' + 
			",user_mentions = '" + userMentions + '\'' + 
			",symbols = '" + symbols + '\'' + 
			"}";
		}
}