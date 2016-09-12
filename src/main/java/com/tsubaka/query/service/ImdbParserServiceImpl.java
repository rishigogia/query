package com.tsubaka.query.service;

import com.tsubaka.query.serviceobject.Api;
import com.tsubaka.query.serviceobject.ResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImdbParserServiceImpl implements MovieParserService {

	private Api api;
	private RestTemplate restTemplate;
	private List<HttpMessageConverter<?>> messageConverters;

	public ResultList getMovieDetails(String movieName) {

		restTemplate.setMessageConverters(messageConverters);
		/*HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML));

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);*/

		ResponseEntity<ResultList> responseEntity = restTemplate.getForEntity(this.api.getUrl(), ResultList.class, movieName);
		ResultList resultList = responseEntity.getBody();
		return resultList;
	}

	@Autowired
	public void setApi(Api api) {
		this.api = api;
	}

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Autowired
	public void setMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
		this.messageConverters = messageConverters;
	}
}
