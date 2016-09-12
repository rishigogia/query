package com.tsubaka.query.service;

import com.tsubaka.query.serviceobject.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("apiReferenceService")
public class ApiReferenceService {

	private static final String API = "api";
	private List<Api> apiReferenceList;

	@Autowired
	public void setApiReferenceList(List<Api> apiReferenceList) {
		this.apiReferenceList = apiReferenceList;
	}

	public boolean validateSupportedApis() {
		boolean apiSupported = false;
		String apiName = System.getProperty(API);
		for (Api api:apiReferenceList) {
			if (api.getApiName().equalsIgnoreCase(apiName)) {
				apiSupported = true;
				break;
			}
		}
		return apiSupported;
	}

	public List<Api> getApiReferenceList() {
		return apiReferenceList;
	}
}
