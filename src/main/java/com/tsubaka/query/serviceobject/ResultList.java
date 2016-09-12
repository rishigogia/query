package com.tsubaka.query.serviceobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties({"totalResults","Response", "Error"})
public class ResultList {
	@JsonProperty("Search")
	private List<Result> resultList;
	private int totalResults;
	private String response;

	public String toString () {
		return "{Search: " + resultList + ", totalResults: " + totalResults + ", Response: " + response + "}";
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}

	public List<Result> getResultList() {
		return resultList;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public String getResponse() {
		return response;
	}
}
