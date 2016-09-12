package com.tsubaka.query.serviceobject;

import org.springframework.beans.factory.annotation.Autowired;

public class Api {

	private String apiName;
	private String url;


	public String getApiName() {
		return apiName;
	}

	@Autowired
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getUrl() {
		return url;
	}

	@Autowired
	public void setUrl(String url) {
		this.url = url;
	}
}
